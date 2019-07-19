package com.azure.foodfinder.dataClasses

import java.io.Serializable

data class Ingredient(
    val text: String,
    val weight: Double
): Serializable