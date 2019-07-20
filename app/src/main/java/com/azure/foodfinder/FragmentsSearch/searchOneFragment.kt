package com.azure.foodfinder.FragmentsSearch


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.azure.foodfinder.R
import com.azure.foodfinder.RetrofitStuff.RetroConfig
import com.azure.foodfinder.RetrofitStuff.RetroConfig.initService
import com.azure.foodfinder.RetrofitStuff.RetroConfig.url
import com.azure.foodfinder.dataClasses.principales.inputFood
import kotlinx.android.synthetic.main.fragment_search_one.*
import retrofit2.Call
import retrofit2.Response


class searchOneFragment : Fragment() {
    lateinit var inputFood: inputFood

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Start Routing for retrofit to connect with the api :D
        initService(url)
        searchButton.setOnClickListener {
            val search = searchInput.text.toString()
            getRecipesByName(search)
        }
        //init the function to get a recipe

    }

    fun getRecipesByName(searchValue: String) {
        val call = RetroConfig.service.getRecipesByName(recipeName = searchValue)
        call.enqueue(object : retrofit2.Callback<inputFood> {
            override fun onFailure(call: Call<inputFood>, t: Throwable) {
                Log.e(
                    "output", "Something went wrong during connection to API" +
                            t.message
                )
            }

            override fun onResponse(call: Call<inputFood>, response: Response<inputFood>) {
                Log.d("output", "Connection successful")
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    inputFood = body
                    //Log.d("output", body.toString())
                    inputFood = body
                    Log.d("output", inputFood.hits.toString())

                } else {
                    Log.e("output", "Body is empty")
                }

            }

        })
    }


}