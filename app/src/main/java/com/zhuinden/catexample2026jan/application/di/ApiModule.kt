package com.zhuinden.catexample2026jan.application.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.Strictness
import com.zhuinden.catexample2026jan.data.api.CatApi
import com.zhuinden.catexample2026jan.data.api.CatApiImpl
import com.zhuinden.catexample2026jan.data.api.CatApiInterceptor
import com.zhuinden.catexample2026jan.data.api.RetrofitCatApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun catApi(retrofit: Retrofit): CatApi = CatApiImpl(
        catApi = retrofit.create(RetrofitCatApi::class.java)
    )

    @Provides
    @Singleton
    fun gson(): Gson = GsonBuilder()
        .setStrictness(Strictness.LENIENT)
        .create()

    @Provides
    @Singleton
    fun retrofit(
        okHttpClient: OkHttpClient,
        gson: Gson,
    ): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    @Singleton
    fun okHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(CatApiInterceptor())
        .build()
}