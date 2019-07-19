package com.azure.foodfinder.dataClasses

import java.io.Serializable

data class inputFood(
    val count: Int,
    val from: Int,
    val hits: List<Hit>
    //val more: Boolean,
    //val params: Params,
    //val q: String,
    //val to: Int
): Serializable


