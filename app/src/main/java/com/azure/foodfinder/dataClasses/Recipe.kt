package com.azure.foodfinder.dataClasses

data class Recipe(
    val calories: Double,
    val cautions: List<String>,
    val dietLabels: List<Any>,
    val healthLabels: List<String>,
    val image: String,
    val ingredientLines: List<String>,
    val ingredients: List<Ingredient>,
    val label: String,
    val shareAs: String,
    val source: String,
    val totalTime: Int,
    val totalWeight: Double,
    val uri: String,
    val url: String,
    val yield: Int
)