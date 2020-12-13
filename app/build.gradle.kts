import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinAndroidExtension)
    kotlin(Plugins.kotlinKapt)
}

val javaVersion: JavaVersion by extra { JavaVersion.VERSION_1_8 }

android {
    compileSdkVersion(extra["compileSdkVersion"] as Int)
    defaultConfig {
        applicationId = "com.techchallenge.marketim"
        minSdkVersion(extra["minSdkVersion"] as Int)
        targetSdkVersion(extra["targetSdkVersion"] as Int)
        versionCode = 1
        versionName = getSemanticAppVersionName()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
        }
    }

    sourceSets {
        val main by getting
        main.java.srcDirs("src/main/kotlin")
    }

    packagingOptions {
        pickFirst("mockito-extensions/org.mockito.plugins.MockMaker")
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
        unitTests.isIncludeAndroidResources = true
    }

    dataBinding {
        isEnabled = true
    }

    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    androidExtensions {
        isExperimental = true
    }

    lintOptions {
        isAbortOnError = false
        isWarningsAsErrors = true
        isCheckDependencies = true
        isIgnoreTestSources = true
        lintConfig = file("lint.xml")
        disable("GradleDeprecated")
        disable("OldTargetApi")
        disable("GradleDependency")
    }

    tasks.withType<JavaCompile> {
        options.isIncremental = true
        allprojects {
            options.compilerArgs.addAll(
                arrayOf(
                    "-Xlint:-unchecked",
                    "-Xlint:deprecation",
                    "-Xdiags:verbose"
                )
            )
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = javaVersion.toString()
            allWarningsAsErrors = true
        }
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
        unitTests.isIncludeAndroidResources = true
        animationsDisabled = true
    }

    configurations {
        all {
            exclude(mapOf("group" to "com.google.guava", "module" to "listenablefuture"))
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    api(project(Modules.core))
    api(project(Modules.data))
    api(project(Modules.domain))

    api(Dependencies.kotlin)
    api(Dependencies.material)
    api(Dependencies.constraint_layout)
    api(Dependencies.core_ktx)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.android_annotation)

    implementation(Dependencies.lifecycle_extensions)
    implementation(Dependencies.lifecycle_runtime)
    implementation(Dependencies.lifecycle_viewmodel)
    kapt(Dependencies.lifecycle_compiler)

    implementation(Dependencies.dagger)
    implementation(Dependencies.dagger_android)
    api(Dependencies.dagger_android_support)
    compileOnly(Dependencies.javax_annotation)
    kapt(Dependencies.dagger_android_processor)
    kapt(Dependencies.dagger_compiler)

    api(Dependencies.rx_java)
    implementation(Dependencies.rx_android)
    implementation(Dependencies.rx_kotlin)

    api(Dependencies.okHttp)
    api(Dependencies.logging)
    api(Dependencies.retrofit)
    api(Dependencies.gson)

    api(Dependencies.timber_kt)

    debugApi(Dependencies.leakcanary)

    testImplementation(TestDependencies.test_core)
    testImplementation(TestDependencies.runner)
    testImplementation(TestDependencies.rules)
    testImplementation(TestDependencies.junit)
    testImplementation(TestDependencies.truth_ext)
    testImplementation(TestDependencies.truth)
    testImplementation(TestDependencies.espresso_core)
    testImplementation(TestDependencies.mockito)
    testImplementation(TestDependencies.arch_core)

    androidTestImplementation(TestDependencies.test_core)
    androidTestImplementation(TestDependencies.rules)
    androidTestImplementation(TestDependencies.junit)
    androidTestImplementation(TestDependencies.truth) {
        exclude(mapOf("group" to "com.google.guava", "module" to "listenablefuture"))
    }
    androidTestImplementation(TestDependencies.truth_ext) {
        exclude(mapOf("group" to "com.google.guava", "module" to "listenablefuture"))
    }
    androidTestImplementation(TestDependencies.espresso_core)
}

fun getSemanticAppVersionName(): String {
    val majorCode = 1
    val minorCode = 0
    val patchCode = 0

    return "$majorCode.$minorCode.$patchCode"
}
