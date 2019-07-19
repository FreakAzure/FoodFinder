package com.azure.foodfinder.dataClasses.principales

data class Hit(
    val bookmarked: Boolean,
    val bought: Boolean,
    val recipe: Recipe
)