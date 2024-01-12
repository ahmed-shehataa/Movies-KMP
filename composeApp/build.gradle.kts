import dev.icerock.gradle.MRVisibility
import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.mokoResources)
    alias(libs.plugins.serialization)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    jvm("desktop")
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        val desktopMain by getting {
            dependsOn(commonMain.get())
            dependencies {
                implementation(compose.desktop.currentOs)

            }
        }

        val androidMain by getting {
            dependsOn(commonMain.get())
            dependencies {
                implementation(libs.compose.ui.tooling.preview)
                implementation(libs.androidx.activity.compose)
                implementation(libs.koin.android)
            }
        }

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            implementation(libs.preference.core)
            implementation(libs.preference.coroutines)
            implementation(libs.preference.serialization)
            implementation(libs.kotlinx.serialization)
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.napier)
            implementation(libs.kotlinx.coroutines.core)

        }
    }
}

dependencies {
    commonMainApi(libs.moko.resources)
    commonMainApi(libs.moko.mvvm)
    commonMainApi(libs.moko.flow)
    commonMainApi(libs.moko.core)

}


val myNamespace = "com.shehata.movies_kmp"
android {
    namespace = myNamespace
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/resources")
        resources.srcDirs("src/commonMain/resources")
    }

    defaultConfig {
        applicationId = "com.shehata.movies_kmp"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.shehata.movies_kmp"
            packageVersion = "1.0.0"
        }
    }
}

multiplatformResources {
    multiplatformResourcesPackage = myNamespace // required
    multiplatformResourcesClassName = "Resources" // optional, default MR
    multiplatformResourcesVisibility = MRVisibility.Internal // optional, default Public
    iosBaseLocalizationRegion = "en" // optional, default "en"
    multiplatformResourcesSourceSet = "commonMain"  // optional, default "commonMain"
}
