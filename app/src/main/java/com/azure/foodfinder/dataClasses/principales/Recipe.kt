package com.azure.foodfinder.dataClasses.principales

import com.azure.foodfinder.demasClases.Digest

data class Recipe(
    val ingredientLines: List<String>,
    val ingredients: List<Ingredient>,
    val calories: Double,
    val cautions: List<String>,
    val dietLabels: List<String>,
    val digest: List<Digest>,
    val healthLabels: List<String>,
    val image: String,
    val label: String,
    val shareAs: String,
    val source: String,
    val totalDaily: TotalDaily,
    val totalNutrients: TotalNutrients,
    val totalTime: Int,
    val totalWeight: Double,
    val uri: String,
    val url: String,
    val yield: Int
)