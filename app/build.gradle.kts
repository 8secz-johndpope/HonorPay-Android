plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("androidx.navigation.safeargs")
    id("com.google.gms.google-services") apply false
}

// https://github.com/gradle/kotlin-dsl/issues/644#issuecomment-454594727
// https://youtrack.jetbrains.com/issue/KT-22213
apply { from("experimentalExtensions.gradle") }

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.freeworldone.honorpay"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        resValue("string", "app_version", "v$versionName")
        resValue("string", "app_name", "HonorPay")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
            resValue("string", "app_name", "DevHonorPay")
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules-debug.pro")
        }
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions.sourceCompatibility = JavaVersion.VERSION_1_8
    compileOptions.targetCompatibility = JavaVersion.VERSION_1_8
    dataBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(kotlin("stdlib", "1.3.21"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.1.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.1.1")
    implementation("androidx.annotation:annotation:1.0.1")
    implementation("androidx.appcompat:appcompat:1.1.0-alpha02")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-alpha3")
    implementation("androidx.core:core-ktx:1.0.1")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.0.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.0.0")
    implementation("androidx.lifecycle:lifecycle-runtime:2.0.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0-alpha02")
    implementation("android.arch.navigation:navigation-fragment-ktx:1.0.0-beta01")
    implementation("android.arch.navigation:navigation-runtime-ktx:1.0.0-beta01")
    implementation("android.arch.navigation:navigation-ui-ktx:1.0.0-beta01")
    implementation("com.google.firebase:firebase-core:16.0.7")
    implementation("com.google.firebase:firebase-auth:16.1.0")
    implementation("com.firebaseui:firebase-ui-auth:4.1.0")
    implementation("com.google.android.gms:play-services-auth:16.0.1")
    implementation("com.google.android.gms:play-services-identity:16.0.0")
    implementation("com.google.android.material:material:1.1.0-alpha03")
    implementation("com.squareup.moshi:moshi:1.8.0")
    implementation("com.squareup.okhttp3:okhttp:3.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:3.12.0")
    implementation("com.squareup.okio:okio:2.1.0")
    implementation("com.squareup.picasso:picasso:2.71828")
    implementation("com.squareup.retrofit2:retrofit:2.5.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.5.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    implementation("com.github.ihsanbal:LoggingInterceptor:2.0.7")
    androidTestImplementation("androidx.test:runner:1.1.2-alpha01")
    androidTestImplementation("android.arch.navigation:navigation-testing-ktx:1.0.0-alpha06")
    testImplementation("androidx.arch.core:core-testing:2.0.0")
    testImplementation("junit:junit:4.13-beta-1")
}

apply(plugin = "com.google.gms.google-services")