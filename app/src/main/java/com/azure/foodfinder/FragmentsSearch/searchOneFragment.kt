package com.azure.foodfinder.FragmentsSearch


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.azure.foodfinder.R
import com.azure.foodfinder.RetrofitStuff.RetroConfig
import com.azure.foodfinder.RetrofitStuff.RetroConfig.initService
import com.azure.foodfinder.RetrofitStuff.RetroConfig.url
import com.azure.foodfinder.dataClasses.principales.inputFood
import com.azure.foodfinder.objects.filterClass
import kotlinx.android.synthetic.main.fragment_search_one.*
import kotlinx.android.synthetic.main.item.*
import retrofit2.Call
import retrofit2.Response
import java.util.logging.Filter


class searchOneFragment : Fragment() {
    lateinit var inputFood: inputFood
    lateinit var filter: String
    val doFilter = false


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
            val adapter = ArrayAdapter<String>(context!!, R.layout.fragment_search_one, filterClass.filters)
            //getRecipesByName(search)
            //getRecipesFiltered(search, filterClass.filters[2])
            spinner(filterClass.filters)
            if (doFilter) {
                getRecipesByName(searchInput.text.toString())
            } else {
                getRecipesFiltered(searchInput.text.toString(), filter)
            }
            //init the function to get a recipe

        }


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

    fun getRecipesFiltered(searchValue: String, filter: String) {
        val call = RetroConfig.service.getRecipesFiltered(recipeName = searchValue, filter = filter)
        call.enqueue(object : retrofit2.Callback<inputFood> {
            override fun onFailure(call: Call<inputFood>, t: Throwable) {
                Log.e(
                    "output", "something went wrong during connection to API" +
                            t.message
                )

            }

            override fun onResponse(call: Call<inputFood>, response: Response<inputFood>) {
                val body = response.body()
                if (body != null && response.isSuccessful) {

                    Log.d("output", body.toString())
                }


            }

        })
    }

    fun spinner(filter: List<String>): String {
        lateinit var filtered: String
        val dataAdapter = ArrayAdapter<String>(context!!, R.layout.fragment_search_one, filter)
        spinnerThing.adapter = dataAdapter
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerThing.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                filtered = filter[p2]
                Log.v("filter", filtered)
            }


        }
        return filtered

    }
}