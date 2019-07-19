package com.azure.foodfinder.dataClasses

import java.io.Serializable

data class Recipe(
    val calories: Double,
    val dietLabels: List<Any>,
    val healthLabels: List<String>,
    val image: String,
    val ingredientLines: List<String>,
    val ingredients: List<Ingredient>,
    val label: String,
    val source: String,
    val totalTime: Int,
    val totalWeight: Double,
    val uri: String,
    val url: String,
    val yield: Int
): Serializable