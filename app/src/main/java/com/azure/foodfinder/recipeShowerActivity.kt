package com.azure.foodfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azure.foodfinder.Navigation.Navigator.ChangeFragment
import com.azure.foodfinder.RetrofitStuff.RetroConfig.inputed
import com.azure.foodfinder.fragments.ListFragment
import kotlinx.android.synthetic.main.activity_recipe_shower.*

class recipeShowerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_shower)
        setSupportActionBar(miToolbar)

        getSupportActionBar()?.setTitle("Search: $inputed")

        ChangeFragment(this, ListFragment(), R.id.mainFrame,"listFragment", false)


    }
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
        } else {
            super.onBackPressed()
        }
    }
}
