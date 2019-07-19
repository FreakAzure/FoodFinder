package com.azure.foodfinder.RetrofitStuff

import com.azure.foodfinder.dataClasses.principales.inputFood
import com.azure.foodfinder.objects.FoodApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    //  @GET("genre/movie/list")
    // fun getGenre(@Query("api_key") api_key : String = RetrofitConfig.apiKey, @Query("language") language: String = "es-ES"): Call<>


    @GET("search")
    fun getRecipesByName(@Query("q") recipeName: String = "pizza",
                         @Query("app_id") app_id: String = FoodApi.appID,
                         @Query("app_key") app_key: String = FoodApi.appKEY
                         ):Call<inputFood>


    @GET("search")
    fun getRecipesFiltered(@Query("q") recipeName: String = "pizza",
                         @Query("app_id") app_id: String = FoodApi.appID,
                         @Query("app_key") app_key: String = FoodApi.appKEY,
                         @Query("health") filter: String = ""):Call<inputFood>
}