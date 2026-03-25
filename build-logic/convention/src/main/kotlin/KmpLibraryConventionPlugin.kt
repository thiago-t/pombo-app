import com.android.build.api.dsl.LibraryExtension
import com.ttlabz.pombo.convention.configureKotlinAndroid
import com.ttlabz.pombo.convention.configureKotlinMultiplatform
import com.ttlabz.pombo.convention.libs
import com.ttlabz.pombo.convention.pathResourcePrefix
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class KmpLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.multiplatform")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            configureKotlinMultiplatform()

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)

                resourcePrefix = this@with.pathResourcePrefix()

                // Required to make debug build of app rn in iOS simulator
                experimentalProperties["android.experimental.kmp.enableAndroidResource"] = true
            }

            dependencies {
                "commonMainImplementation"(libs.findLibrary("kotlinx.serialization.json").get())
                "commonTestImplementation"(libs.findLibrary("kotlin.test").get())
            }
        }
    }

}