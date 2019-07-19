package com.azure.foodfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azure.foodfinder.FragmentsSearch.searchOneFragment
import com.azure.foodfinder.Navigation.Navigator.ChangeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ChangeFragment(this, searchOneFragment(), "searchOne", false)


    }
}
