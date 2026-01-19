package com.zhuinden.catexample2026jan.data.api

import com.zhuinden.catexample2026jan.data.api.models.CatResponse
import retrofit2.http.GET

interface RetrofitCatApi {
    @GET("v1/images/search")
    suspend fun getCatList(): List<CatResponse>
}