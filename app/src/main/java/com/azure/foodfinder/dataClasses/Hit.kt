package com.azure.foodfinder.dataClasses

import java.io.Serializable

data class Hit(
    val bookmarked: Boolean,
    val bought: Boolean,
    val recipe: Recipe
): Serializable