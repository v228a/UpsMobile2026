import org.jetbrains.kotlin.context.ProjectContext
import java.util.Properties

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false
}

// Load API key from local.properties
val localProperties = Properties()
project.rootProject.file("local.properties").takeIf { it.exists() }?.inputStream()?.use {
    localProperties.load(it)
}

extra["mapkitApiKey"] = localProperties.getProperty("MAPKIT_API_KEY", "")