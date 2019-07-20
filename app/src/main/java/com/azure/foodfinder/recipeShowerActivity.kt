package com.azure.foodfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.azure.foodfinder.RetrofitStuff.RetroConfig.data
import com.azure.foodfinder.RetrofitStuff.RetroConfig.inputed

class recipeShowerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_shower)
        Log.v("extra", inputed)
        Log.v("extra", data.toString())

    }
}
