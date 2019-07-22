package com.azure.foodfinder.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.azure.foodfinder.RetrofitStuff.RetroConfig.recipeData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_recipe.*


class RecipeFragment : Fragment() {

    lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.azure.foodfinder.R.layout.fragment_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.get().load(recipeData.image).into(recipeImage)
        recipeName.text = recipeData.label
        source.text = "Source: ${recipeData.source}"
        setIngredients(recipeData.ingredientLines)
        showUrl.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeData.url))
            startActivity(browserIntent)
        }
    }

    fun setIngredients(ingredients: List<String>) {
        var ingredientLined = ""
        for ((index, item) in ingredients.withIndex()) {
            ingredientLined += ". $item  \n"
        }
        Log.v("ingrediens", ingredientLined)
        ingredientList.text = ingredientLined
    }
}