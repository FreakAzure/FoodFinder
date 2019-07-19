package com.azure.foodfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.azure.foodfinder.FragmentsSearch.searchOneFragment
import com.azure.foodfinder.Navigation.Navigator.ChangeFragment
import com.azure.foodfinder.RetrofitStuff.RetroConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ChangeFragment(this, searchOneFragment(), "searchOne", false)


    }

}
