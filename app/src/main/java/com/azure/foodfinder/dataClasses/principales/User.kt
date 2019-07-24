package com.azure.foodfinder.dataClasses.principales

import java.io.Serializable

data class User(
    val userName: String,
    val UID: String,
    val favRecipe: ArrayList<String>
    ):Serializable
