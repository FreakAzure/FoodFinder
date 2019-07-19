package com.azure.foodfinder.dataClasses

data class Hit(
    val bookmarked: Boolean,
    val bought: Boolean,
    val recipe: Recipe
)