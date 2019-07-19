package com.azure.foodfinder.RetrofitStuff

import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    //  @GET("genre/movie/list")
    // fun getGenre(@Query("api_key") api_key : String = RetrofitConfig.apiKey, @Query("language") language: String = "es-ES"): Call<>


    @GET("?")
    fun getRecipes()
}