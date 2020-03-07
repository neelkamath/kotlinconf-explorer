package com.neelkamath.kotlinconf_explorer.components

import com.neelkamath.kotlinconf_explorer.Video
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.p

interface VideoListProps : RProps {
    var videos: List<Video>
}

interface VideoListState : RState {
    var selectedVideo: Video?
}

class VideoList : RComponent<VideoListProps, VideoListState>() {
    override fun RBuilder.render() {
        for (video in props.videos)
            p {
                key = video.id.toString()
                attrs {
                    onClickFunction = {
                        setState { selectedVideo = video }
                    }
                }
                if (video == state.selectedVideo) +"▶ "
                +"${video.speaker}: ${video.title}"
            }
    }
}

fun RBuilder.videoList(handler: VideoListProps.() -> Unit): ReactElement = child(VideoList::class) { attrs(handler) }