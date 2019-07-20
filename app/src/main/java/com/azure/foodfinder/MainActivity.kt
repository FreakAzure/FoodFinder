package com.azure.foodfinder

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.azure.foodfinder.Navigation.Navigator
import com.azure.foodfinder.RetrofitStuff.RetroConfig
import com.azure.foodfinder.RetrofitStuff.RetroConfig.data
import com.azure.foodfinder.RetrofitStuff.RetroConfig.initService
import com.azure.foodfinder.RetrofitStuff.RetroConfig.inputed
import com.azure.foodfinder.RetrofitStuff.RetroConfig.url
import com.azure.foodfinder.dataClasses.principales.Hit
import com.azure.foodfinder.dataClasses.principales.Recipe
import com.azure.foodfinder.dataClasses.principales.inputFood
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
        spinner(filterClass.filters)
        var filter = spinner(filterClass.filters)


        searchButton.setOnClickListener{
            getRecipesByName(searchInput.text.toString())

        }



    }

    fun spinner(filter: List<String>): String{
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

    fun getRecipesByName(search : String){
        val call = RetroConfig.service.getRecipesByName(recipeName = search)
        call.enqueue(object : Callback<inputFood>{
            override fun onFailure(call: Call<inputFood>, t: Throwable) {
                Log.e("output", "Something went wrong while connecting -- $t")
            }

            override fun onResponse(call: Call<inputFood>, response: Response<inputFood>) {
            val body = response.body()
                if(response.isSuccessful && body != null){
                    data = body.hits
                    inputed = search
                    changeActivity()

                }else{
                    Log.v("output", "body comes empty")
                }

            }

        })

    }
    fun changeActivity(){
        val intent = Intent(this, recipeShowerActivity::class.java)
        startActivity(intent)
    }
}