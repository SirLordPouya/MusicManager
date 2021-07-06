plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "ir.heydarii.musicmanager"
        minSdk = 21
        targetSdk = 30
        versionCode = 500
        versionName = "5.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

//        javaCompileOptions {
//            annotationProcessorOptions {
//                arguments = ["room.incremental": "true"]
//            }
//        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        dataBinding = true
    }
    compileOptions {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    //Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")

    //Support
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("com.google.android.material:material:${rootProject.extra["support_version"]}")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    //Test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    //REST
    implementation("com.squareup.retrofit2:retrofit:${rootProject.extra["retrofit_version"]}")
    implementation("com.squareup.retrofit2:adapter-rxjava2:${rootProject.extra["retrofit_version"]}")
    implementation("com.squareup.retrofit2:converter-gson:${rootProject.extra["retrofit_version"]}")
    implementation("com.google.code.gson:gson:2.8.6")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    //Rx
    implementation("io.reactivex.rxjava2:rxjava:${rootProject.extra["rxjava_Version"]}")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")

    //LiveData and ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${rootProject.extra["lifecycle_version"]}")

    //Dagger
    implementation("com.google.dagger:dagger:${rootProject.extra["dagger_version"]}")
    kapt("com.google.dagger:dagger-compiler:${rootProject.extra["dagger_version"]}")
    implementation("com.google.dagger:dagger-android:${rootProject.extra["dagger_version"]}")
    implementation("com.google.dagger:dagger-android-support:${rootProject.extra["dagger_version"]}")
    kapt("com.google.dagger:dagger-android-processor:${rootProject.extra["dagger_version"]}")

    //Logger
    implementation("com.orhanobut:logger:2.2.0")

    //Picasso
    implementation("com.squareup.picasso:picasso:2.71828")

    //lottie
    implementation("com.airbnb.android:lottie:3.4.1")

    //Room
    implementation("androidx.room:room-runtime:${rootProject.extra["room_version"]}")
    kapt("androidx.room:room-compiler:${rootProject.extra["room_version"]}")
    implementation("androidx.room:room-rxjava2:${rootProject.extra["room_version"]}")

    //Navigation component
    implementation("androidx.navigation:navigation-fragment-ktx:${rootProject.extra["nav_version"]}")
    implementation("androidx.navigation:navigation-ui-ktx:${rootProject.extra["nav_version"]}")

}