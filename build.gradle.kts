// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.pluginid.kotlin.android) apply false
    alias(libs.plugins.pluginid.android.application) apply false
    alias(libs.plugins.pluginid.kotlin.compose) apply false
    alias(libs.plugins.pluginid.com.google.devtools.ksp) apply false
    alias(libs.plugins.pluginid.com.google.dagger.hilt.android) apply false
}