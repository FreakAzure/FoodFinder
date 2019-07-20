package com.azure.foodfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azure.foodfinder.Navigation.Navigator.ChangeFragment
import com.azure.foodfinder.fragments.ListFragment

class recipeShowerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_shower)
        ChangeFragment(this, ListFragment(), "listFragment", false)

    }
}
