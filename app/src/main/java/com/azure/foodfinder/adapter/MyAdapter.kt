package com.azure.foodfinder.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azure.foodfinder.R
import com.azure.foodfinder.dataClasses.principales.Hit
import com.azure.foodfinder.dataClasses.principales.Recipe
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class MyAdapter(private val dame: ArrayList<Hit>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dame[position])
    }

    override fun getItemCount(): Int {
        return dame.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("ResourceAsColor")
        fun bind(item: Hit) {
            var calory = item.recipe.calories.toInt()
            var servings = item.recipe.yield
            Picasso.get().load(item.recipe.image).into(itemView.recipePic)
            itemView.recipeName.text = item.recipe.label
            itemView.calories.text = "$calory Kcal"
            itemView.health.text = item.recipe.healthLabels[0]
            itemView.yield.text = "Servings: $servings"


        }
    }
}