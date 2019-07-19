package com.azure.foodfinder.dataClasses.principales

data class inputFood(
    val count: Int,
    val from: Int,
    val hits: ArrayList<Hit>,
    val more: Boolean,
    val params: Params,
    val q: String,
    val to: Int
)