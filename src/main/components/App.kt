package com.neelkamath.kotlinconf_explorer.components

import com.neelkamath.kotlinconf_explorer.Video
import com.neelkamath.kotlinconf_explorer.unwatchedVideos
import com.neelkamath.kotlinconf_explorer.watchedVideos
import kotlinx.css.*
import react.*
import react.dom.div
import react.dom.h1
import react.dom.h3
import react.dom.img
import styled.css
import styled.styledDiv

interface AppState : RState {
    var currentVideo: Video?
}

class App : RComponent<RProps, AppState>() {
    override fun RBuilder.render() {
        h1 { +"KotlinConf Explorer" }
        div {
            h3 { +"Videos to watch" }
            videoList {
                videos = unwatchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = {
                    setState { currentVideo = it }
                }
            }
            h3 { +"Videos watched" }
            videoList {
                videos = watchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = {
                    setState { currentVideo = it }
                }
            }
        }
        styledDiv {
            css {
                position = Position.absolute
                right = 10.px
                top = 10.px
            }
            h3 { +"John Doe: Building and breaking things" }
            img {
                attrs { src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder" }
            }
        }
    }
}