object Dependencies {
    // Core
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_gradle_plugin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraint_layout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val android_annotation = "androidx.annotation:annotation:${Versions.android_annotation}"

    // Dagger
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val dagger_android = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val dagger_android_support = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val dagger_android_processor =
        "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    const val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val javax_annotation = "org.glassfish:javax.annotation:${Versions.javax}"

    // Lifecycle
    const val lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
    const val lifecycle_compiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.lifecycle}"
    const val lifecycle_viewmodel_ktx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    // RxJava
    const val rx_android = "io.reactivex.rxjava2:rxandroid:${Versions.rx_android}"
    const val rx_java = "io.reactivex.rxjava2:rxjava:${Versions.rx_java}"
    const val rx_kotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rx_kotlin}"
    const val rxjava2_adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val rx_binding = "com.jakewharton.rxbinding3:rxbinding-material:${Versions.rx_binding}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    // Leakcanary
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanary}"

    // Timber
    const val timber_kt = "com.github.ajalt:timberkt:${Versions.timberkt}"
}

object TestDependencies {
    // Core library
    const val test_core = "androidx.test:core:${Versions.test_core}"
    const val arch_core = "android.arch.core:core-testing:${Versions.arch_core}"

    // AndroidJUnitRunner and JUnit Rules
    const val runner = "androidx.test:runner:${Versions.runner}"
    const val rules = "androidx.test:rules:${Versions.rules}"

    // Assertions
    const val junit = "androidx.test.ext:junit:${Versions.junit}"
    const val truth_ext = "androidx.test.ext:truth:${Versions.truth_ext}"
    const val truth = "com.google.truth:truth:${Versions.truth}"

    // Espresso dependencies
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"

    // Third party
    const val mockito = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockito}"
}
