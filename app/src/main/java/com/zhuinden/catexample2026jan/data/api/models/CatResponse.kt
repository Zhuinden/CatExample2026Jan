package com.zhuinden.catexample2026jan.data.api.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CatResponse(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("width")
    var width: Int? = null,
    @SerializedName("height")
    var height: Int? = null,
)