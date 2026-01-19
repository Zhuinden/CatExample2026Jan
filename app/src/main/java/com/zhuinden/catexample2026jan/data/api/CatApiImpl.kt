package com.zhuinden.catexample2026jan.data.api

import com.zhuinden.catexample2026jan.data.api.models.CatResponse

class CatApiImpl(
    private val catApi: RetrofitCatApi,
) : CatApi {
    override suspend fun getCatList(): List<CatResponse> = catApi.getCatList()
}