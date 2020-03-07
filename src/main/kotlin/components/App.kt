import kotlinx.coroutines.*
import react.*
import react.dom.div
import react.dom.h1
import react.dom.h3
import kotlin.browser.window

interface AppState : RState {
    var currentVideo: Video?
    var unwatchedVideos: List<Video>
    var watchedVideos: List<Video>
}

class App : RComponent<RProps, AppState>() {
    override fun AppState.init() {
        unwatchedVideos = listOf()
        watchedVideos = listOf()
        MainScope().launch {
            val videos = fetchVideos()
            setState { unwatchedVideos = videos }
        }
    }

    override fun RBuilder.render() {
        h1 { +"KotlinConf Explorer" }
        div {
            h3 { +"Videos to watch" }
            videoList {
                videos = state.unwatchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = {
                    setState { currentVideo = it }
                }
            }
            h3 { +"Videos watched" }
            videoList {
                videos = state.watchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = {
                    setState { currentVideo = it }
                }
            }
        }
        state.currentVideo?.let {
            videoPlayer {
                video = state.currentVideo!!
                unwatchedVideo = state.currentVideo!! in state.unwatchedVideos
                onWatchedButtonPressed = {
                    if (video in state.unwatchedVideos)
                        setState {
                            unwatchedVideos -= video
                            watchedVideos += video
                        }
                    else
                        setState {
                            watchedVideos -= video
                            unwatchedVideos += video
                        }
                }
            }
        }
    }
}

suspend fun fetchVideos(): List<Video> = coroutineScope {
    (1..25)
        .map {
            async { fetchVideo(it) }
        }
        .awaitAll()
}

suspend fun fetchVideo(id: Int): Video =
    window.fetch("https://my-json-server.typicode.com/kotlin-hands-on/kotlinconf-json/videos/$id")
        .await()
        .json()
        .await()
        .unsafeCast<Video>()