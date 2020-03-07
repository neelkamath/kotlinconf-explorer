import react.dom.render
import kotlin.browser.document

data class Video(val id: Int, val title: String, val speaker: String, val videoUrl: String)

fun main() {
    render(document.querySelector("#root")) {
        child(App::class) { }
    }
}
