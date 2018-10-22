object Versions {
    const val minSdk = "21"
    const val targetSdk = "28"
    const val versionCode = 1
    const val versionName = "1.0"

    const val kotlin = "1.2.71"
    const val gradle = "3.2.0"
    const val fabric = "1.+"
    const val crashlytics = "2.9.5"
    const val timber = "4.7.1"

    const val appCompat = "1.0.0"
    const val fragment = "1.0.0"
    const val constraintLayout = "1.1.3"
    const val multidex = "1.0.0"

    const val hawk = "2.0.1"

//    const val lifecycle = "2.0.0"
//    const val room = "2.0.0"
//    const val anko = "0.10.7"
    const val support = "28.0.0"
    const val retrofit = "2.3.0"
//    const val material = "1.0.0"
    const val leakcanary = "1.6.1"
    const val parceler = "1.1.11"
    const val okHttp = "3.8.0"
    const val espresso = "3.0.2"
    const val rxjava = "2.0.2"
    const val rxandroid = "1.2.1"
    const val rxpermissions = "0.10.2"
    const val dagger2 = "2.12"
    const val junit = "4.12"
    const val runner = "1.0.2"
    const val mockito = "2.23.0"
}

object LibsPrefix {
//    const val anko = "org.jetbrains.anko:anko-"
//    const val lifecycle = "androidx.lifecycle:lifecycle-"
//    const val room = "androidx.room:room-"
    const val retrofit = "com.squareup.retrofit2:"
    const val okhttp3 = "com.squareup.okhttp3:"
    const val reactivex = "io.reactivex"
    const val dagger2 = "com.google.dagger:dagger"
    const val leakcanary = "com.squareup.leakcanary:leakcanary-"
    const val parceler = "org.parceler:parceler"
}

object Libs {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}@aar"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val leakcanary = "${LibsPrefix.leakcanary}android:${Versions.leakcanary}"
    const val leakcanaryFragment = "${LibsPrefix.leakcanary}support-fragment:${Versions.leakcanary}"

    const val multidex = "com.android.support:multidex:${Versions.multidex}"

    const val appCompat = "com.android.support:appcompat-v7:${Versions.support}"
    const val constraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayout}"
    const val fragment = "com.android.support:support-fragment:${Versions.support}"
    const val design = "com.android.support:design:${Versions.support}"

//    const val ankoSdk = "${LibsPrefix.anko}sdk${Versions.minSdk}:${Versions.anko}"
//    const val ankoAppCompact = "${LibsPrefix.anko}appcompat-v7:${Versions.anko}"
//    const val ankoSupportV4 = "${LibsPrefix.anko}support-v4:${Versions.anko}"

//    const val lifecycleExtensions = "${LibsPrefix.lifecycle}extensions:${Versions.lifecycle}"
//    const val lifecycleRuntime = "${LibsPrefix.lifecycle}runtime:${Versions.lifecycle}"
//    const val lifecycleCompiler = "${LibsPrefix.lifecycle}compiler:${Versions.lifecycle}"
//    const val lifecycleTesting = "androidx.arch.core:core-testing:${Versions.lifecycle}"
//
//    const val roomRuntime = "${LibsPrefix.room}runtime:${Versions.room}"
//    const val roomRxJava2 = "${LibsPrefix.room}rxjava2:${Versions.room}"
//    const val roomCompiler = "${LibsPrefix.room}compiler:${Versions.room}"
//    const val roomTesting = "androidx.room:room-testing:${Versions.room}"

    const val retrofit = "${LibsPrefix.retrofit}retrofit:${Versions.retrofit}"
    const val retrofitConverterGson = "${LibsPrefix.retrofit}converter-gson:${Versions.retrofit}"
    const val retrofitRxJava2 = "${LibsPrefix.retrofit}adapter-rxjava2:${Versions.retrofit}"

    const val okhttp3 = "${LibsPrefix.okhttp3}okhttp:${Versions.okHttp}"
    const val okhttp3Interceptor = "${LibsPrefix.okhttp3}logging-interceptor:${Versions.okHttp}"

    const val rxjava2RxAndroid = "${LibsPrefix.reactivex}.rxjava2:rxandroid:${Versions.rxjava}"
    const val rxjava2Rxjava = "${LibsPrefix.reactivex}.rxjava2:rxjava:${Versions.rxjava}"
    const val rxandroid = "${LibsPrefix.reactivex}:rxandroid:${Versions.rxandroid}"

    const val rxPermissions = "com.github.tbruyelle:rxpermissions:${Versions.rxpermissions}"

    const val hawk = "com.orhanobut:hawk:${Versions.hawk}"

    const val dagger2 = "${LibsPrefix.dagger2}:${Versions.dagger2}"
    const val dagger2Compiler = "${LibsPrefix.dagger2}-compiler:${Versions.dagger2}"
    const val dagger2Android = "${LibsPrefix.dagger2}-android:${Versions.dagger2}"
    const val dagger2AndroidSupport = "${LibsPrefix.dagger2}-android-support:${Versions.dagger2}"
    const val dagger2Processor = "${LibsPrefix.dagger2}-android-processor:${Versions.dagger2}"

    const val parceler = "${LibsPrefix.parceler}-api:${Versions.parceler}"
    const val parcelerProcessor = "${LibsPrefix.parceler}:${Versions.parceler}"

    const val junit = "junit:junit:${Versions.junit}"
    const val runner = "com.android.support.test:runner:${Versions.runner}"
    const val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
}

object ClassPaths {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val fabricPlugin = "io.fabric.tools:gradle:${Versions.fabric}"
}