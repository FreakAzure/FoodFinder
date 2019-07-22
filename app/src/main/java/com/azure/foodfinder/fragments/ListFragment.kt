package com.azure.foodfinder.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.azure.foodfinder.R
import com.azure.foodfinder.RetrofitStuff.RetroConfig.data
import com.azure.foodfinder.RetrofitStuff.RetroConfig.inputed
import com.azure.foodfinder.adapter.MyAdapter
import kotlinx.android.synthetic.main.lists_fragment.*

class ListFragment : Fragment() {
    lateinit var recicler: RecyclerView
    lateinit var adapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.lists_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v("extra", inputed)
        Log.v("extra", data.toString())


        initAdapter()
        adapter.onClickRecipe = {
            activity?.supportFragmentManager?.beginTransaction()?.replace(
                R.id.mainFrame,
                RecipeFragment(), "redFragment"
            )?.addToBackStack("recipeFragment")?.commit()
        }
        if(data.isEmpty()){
            listLayout.setBackgroundColor(0x0000FF00)
        }

    }

    fun initAdapter() {
        recicler = myRecycler
        val mLayoutManager = LinearLayoutManager(context)
        recicler.layoutManager = mLayoutManager
        adapter = MyAdapter(data)
        recicler.adapter = adapter
    }

}