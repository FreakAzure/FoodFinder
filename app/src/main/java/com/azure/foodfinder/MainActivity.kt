package com.azure.foodfinder

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.azure.foodfinder.RetrofitStuff.RetroConfig
import com.azure.foodfinder.RetrofitStuff.RetroConfig.data
import com.azure.foodfinder.RetrofitStuff.RetroConfig.initService
import com.azure.foodfinder.RetrofitStuff.RetroConfig.inputed
import com.azure.foodfinder.dataClasses.principales.Recipe
import com.azure.foodfinder.dataClasses.principales.inputFood
import com.azure.foodfinder.objects.FoodApi.url
import com.azure.foodfinder.objects.filterClass
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var recipe: ArrayList<Recipe>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Start Routing for retrofit to connect with the api :D
        initService(url)
        disableSpinner(spinnerThing)
        Spinner(filterClass.filters)
        filterCheck.setOnClickListener{
            if(filterCheck.isChecked){
                enableSpinner(spinnerThing)
                //Search recipes with a filter when button pressed
                searchButton.setOnClickListener {
                    if (searchInput.text.toString().isNotEmpty()) {
                        getRecipesWithFilter(searchInput.text.toString(), spinnerThing.selectedItem.toString(), this)
                    } else {
                        Toast.makeText(this, "Please, input a recipe", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                disableSpinner(spinnerThing)
                //search recipes by name when button pressed
                searchButton.setOnClickListener {
                    if (searchInput.text.toString().isNotEmpty()) {
                        getRecipesByName(searchInput.text.toString())
                    } else {
                        Toast.makeText(this, "Please, input a recipe", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        var filter = Spinner(filterClass.filters)

        searchButton.setOnClickListener {
            if (searchInput.text.toString().isNotEmpty()) {
                getRecipesByName(searchInput.text.toString())
            } else {
                Toast.makeText(this, "Please, input a recipe", Toast.LENGTH_SHORT).show()
            }
        }


    }

    fun Spinner(filter: List<String>): String {
        var filtered = ""
        val search = searchInput.text.toString()
        val adapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, filterClass.filters)
        spinnerThing.adapter = adapter
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerThing.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                filtered = ""
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                filtered = filter[p2]
                Log.v("filter", filtered)
            }


        }
        return filtered
    }

    fun getRecipesByName(search: String) {
        val call = RetroConfig.service.getRecipesByName(recipeName = search)
        call.enqueue(object : Callback<inputFood> {
            override fun onFailure(call: Call<inputFood>, t: Throwable) {
                Log.e("output", "Something went wrong while connecting -- $t")
            }
            override fun onResponse(call: Call<inputFood>, response: Response<inputFood>) {
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    data = body.hits
                    inputed = search
                    changeActivity()
                } else {
                    Log.v("output", "body comes empty")
                }
            }
        })
    }

    fun getRecipesWithFilter(search: String, filter: String, context: Context) {
        val call = RetroConfig.service.getRecipesFiltered(recipeName = search, filter = filter)
        call.enqueue(object : Callback<inputFood> {
            override fun onFailure(call: Call<inputFood>, t: Throwable) {
                Log.e("output", "Something went wrong while connecting -- $t")
            }
            override fun onResponse(call: Call<inputFood>, response: Response<inputFood>) {
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    data = body.hits
                    inputed = search
                    changeActivity()
                } else {
                    Log.v("output", "body comes empty")
                }
            }
        })
    }
    //Navigation
    fun changeActivity() {
        val intent = Intent(this, recipeShowerActivity::class.java)
        startActivity(intent)
    }
    //Spinner management
    fun enableSpinner(spinner: Spinner){
        spinner.setEnabled(true)
        spinner.setClickable(true)
        Spinner(filterClass.filters)
    }
    fun disableSpinner(spinner: Spinner){
        spinner.setEnabled(false)
        spinner.setClickable(false)
        Spinner(filterClass.filters)
    }
}