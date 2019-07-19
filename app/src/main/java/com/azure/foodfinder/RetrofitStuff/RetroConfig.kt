package com.azure.foodfinder.RetrofitStuff

import com.azure.foodfinder.objects.FoodApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroConfig {

    lateinit var service: RetroService
    val url = FoodApi.url

    fun initService(url: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(RetroService::class.java)
    }
}