import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.br
import react.dom.h3
import styled.css
import styled.styledButton
import styled.styledDiv
import wrappers.ReactPlayer

interface VideoPlayerProps : RProps {
    var video: Video
    var onWatchedButtonPressed: (Video) -> Unit
    var unwatchedVideo: Boolean
}

class VideoPlayer : RComponent<VideoPlayerProps, RState>() {
    override fun RBuilder.render() {
        styledDiv {
            css {
                position = Position.absolute
                right = 10.px
                top = 10.px
            }
            h3 { +"${props.video.speaker}: ${props.video.title}" }
            styledButton {
                css {
                    display = Display.block
                    backgroundColor = if (props.unwatchedVideo) Color.lightGreen else Color.red
                }
                attrs {
                    onClickFunction = { props.onWatchedButtonPressed(props.video) }
                }
                +if (props.unwatchedVideo) "Mark as watched" else "Mark as unwatched"
            }
            br {}
            styledDiv {
                css {
                    display = Display.flex
                    marginBottom = 10.px
                }
                EmailShareButton {
                    attrs.url = props.video.videoUrl
                    EmailIcon {
                        attrs.size = 32
                        attrs.round = true
                    }
                }

                TelegramShareButton {
                    attrs.url = props.video.videoUrl
                    TelegramIcon {
                        attrs.size = 32
                        attrs.round = true
                    }
                }
            }
            ReactPlayer { attrs.url = props.video.videoUrl }
        }
    }
}

fun RBuilder.videoPlayer(handler: VideoPlayerProps.() -> Unit): ReactElement =
    child(VideoPlayer::class) { attrs(handler) }