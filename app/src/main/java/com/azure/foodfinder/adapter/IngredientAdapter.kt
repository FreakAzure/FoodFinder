package com.azure.foodfinder.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azure.foodfinder.R
import com.azure.foodfinder.recipeShowerActivity
import kotlinx.android.synthetic.main.item_ingredient.view.*

class IngredientAdapter(private val dame: List<String>) : RecyclerView.Adapter<IngredientAdapter.MyViewHolder>() {



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
        @SuppressLint("ResourceAsColor", "SetTextI18n")
        fun bind(item: String) {
            Log.v("ingredient", item)
            itemView.ingredientItem.text = "· $item"

        }
    }
}