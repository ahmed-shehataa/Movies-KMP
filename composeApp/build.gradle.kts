import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import dev.icerock.gradle.MRVisibility
import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

val myNamespace = "com.shehata.movies_kmp"

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.mokoResources)
    alias(libs.plugins.serialization)
    alias(libs.plugins.buildkonfig)
    alias(libs.plugins.sqlDelight)
}

buildkonfig {
    packageName = myNamespace
    defaultConfigs {
        buildConfigField(STRING, "BASE_API_URL", "https://api.themoviedb.org/3/")
        buildConfigField(STRING, "BASE_IMAGE_URL", "https://image.tmdb.org/t/p/")
    }
}

sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set(myNamespace)
        }
    }
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
                implementation(compose.desktop.common)
                implementation(compose.desktop.currentOs)
                implementation(libs.coroutines.swing)
                implementation(libs.sqlDelight.jvm)

            }
        }

        val androidMain by getting {
            dependsOn(commonMain.get())
            dependencies {
                implementation(libs.compose.ui.tooling.preview)
                implementation(libs.androidx.activity.compose)
                implementation(libs.koin.android)
                implementation(libs.coroutines.android)
                implementation(libs.sqlDelight.android)
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain.get())
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(libs.ktor.darwin)
                implementation(libs.sqlDelight.native)
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
            implementation(libs.coroutines.core)
            implementation(libs.voyager.navigator)
            implementation(libs.voyager.screenModel)
            implementation(libs.voyager.koin)
            implementation(libs.voyager.transitions)
            implementation(libs.moko.resources)
            implementation(libs.ktor.core)
            implementation(libs.ktor.cio)
            implementation(libs.ktor.serialization)
            implementation(libs.ktor.negotiation)
            implementation(libs.ktor.logging)
            implementation(libs.coil.compose)
            implementation(libs.coil.network)
            implementation(libs.sqlDelight.coroutines)
            implementation(libs.compose.window.size)


        }
    }
}

android {
    namespace = myNamespace
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/resources")
        resources.srcDirs("src/commonMain/resources")
    }

    defaultConfig {
        applicationId = myNamespace
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
            packageName = myNamespace
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
    disableStaticFrameworkWarning = true
}
