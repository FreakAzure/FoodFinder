package com.azure.foodfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azure.foodfinder.Navigation.Navigator.ChangeFragment
import com.azure.foodfinder.RetrofitStuff.RetroConfig.inputed
import com.azure.foodfinder.fragments.ListFragment
import kotlinx.android.synthetic.main.activity_recipe_shower.*
import kotlinx.android.synthetic.main.toolbar.*

class recipeShowerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_shower)
        setSupportActionBar(miToolbar)

        supportActionBar?.title = "Search: $inputed"
        supportActionBar?.setHomeButtonEnabled(true)

        ChangeFragment(this, ListFragment(), R.id.mainFrame,"listFragment", false)


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()

    }

}
