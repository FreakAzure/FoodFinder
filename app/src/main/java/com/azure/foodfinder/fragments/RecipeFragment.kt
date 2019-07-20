package com.azure.foodfinder.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.azure.foodfinder.R
import com.azure.foodfinder.RetrofitStuff.RetroConfig
import com.azure.foodfinder.adapter.IngredientAdapter
import com.azure.foodfinder.adapter.MyAdapter
import kotlinx.android.synthetic.main.fragment_recipe.*
import kotlinx.android.synthetic.main.lists_fragment.*


class RecipeFragment : Fragment() {

    lateinit var recycler: RecyclerView
    lateinit var adapter: IngredientAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    fun initAdapter() {
        recycler = recyclerIngredients
        val mLayoutManager = LinearLayoutManager(context)
        recycler.layoutManager = mLayoutManager
        adapter = IngredientAdapter(RetroConfig.recipeData.ingredientLines)
        recycler.adapter = adapter
    }
}