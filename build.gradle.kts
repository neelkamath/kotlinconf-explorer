plugins { kotlin("js") version "1.3.70" }

repositories {
    jcenter()
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
}

kotlin {
    sourceSets { getByName("main").kotlin.srcDirs("src/main/kotlin") }
    target.browser { }
}

dependencies {
    implementation(kotlin("stdlib-js"))

    implementation("org.jetbrains:kotlin-react:16.13.0-pre.93-kotlin-1.3.70")
    implementation(npm("react", "16.13.0"))

    implementation("org.jetbrains:kotlin-react-dom:16.13.0-pre.93-kotlin-1.3.70")
    implementation(npm("react-dom", "16.13.0"))

    implementation("org.jetbrains:kotlin-styled:1.0.0-pre.93-kotlin-1.3.70")
    implementation(npm("styled-components"))
    implementation(npm("inline-style-prefixer"))

    implementation(npm("react-player"))
    implementation(npm("react-share"))
}