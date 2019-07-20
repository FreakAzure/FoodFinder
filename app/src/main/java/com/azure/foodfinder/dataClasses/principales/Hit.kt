package com.azure.foodfinder.dataClasses.principales

import java.io.Serializable

data class Hit(
    val bookmarked: Boolean,
    val bought: Boolean,
    val recipe: Recipe
):Serializable