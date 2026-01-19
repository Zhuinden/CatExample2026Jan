package com.zhuinden.catexample2026jan.features.main

import androidx.compose.runtime.Immutable

@Immutable
data class MainState(
    val text: String,
) {
    companion object {
        const val DEFAULT_TEXT = "Hello world"

        val DEFAULT = MainState(
            text = DEFAULT_TEXT,
        )
    }
}