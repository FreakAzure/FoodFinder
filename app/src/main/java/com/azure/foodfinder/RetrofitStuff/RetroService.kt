package com.azure.foodfinder.RetrofitStuff

import com.azure.foodfinder.dataClasses.inputFood
import com.azure.foodfinder.objects.FoodApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    //  @GET("genre/movie/list")
    // fun getGenre(@Query("api_key") api_key : String = RetrofitConfig.apiKey, @Query("language") language: String = "es-ES"): Call<>


    @GET("search?")
    fun getRecipesByName(@Query("app_id") app_id: String = FoodApi.appID,
                         @Query("app_key") app_key: String = FoodApi.appKEY,
                         @Query("q") recipeName: String = "",
                         @Query("health") filter: String = ""):Call<inputFood>
}