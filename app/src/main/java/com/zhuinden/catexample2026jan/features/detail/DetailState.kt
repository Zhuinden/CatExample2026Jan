package com.zhuinden.catexample2026jan.features.detail

import androidx.compose.runtime.Immutable

@Immutable
data class DetailState(
    val text: String,
    val url: String,
) {
    companion object {
        val DEFAULT = DetailState(
            text = "",
            url = "",
        )
    }
}