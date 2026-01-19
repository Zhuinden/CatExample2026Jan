package com.zhuinden.catexample2026jan.data.api

import com.zhuinden.catexample2026jan.data.api.models.CatResponse

interface CatApi {
    suspend fun getCatList(): List<CatResponse>
}