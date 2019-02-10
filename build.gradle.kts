import java.net.URI

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.5.0-alpha03")
        classpath(kotlin("gradle-plugin", "1.3.21"))
        classpath("com.google.gms:google-services:4.2.0")
        classpath("android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0-beta01")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = URI("https://jitpack.io") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}