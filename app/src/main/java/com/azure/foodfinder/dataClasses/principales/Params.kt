package com.azure.foodfinder.dataClasses.principales

data class Params(
    val app_id: List<String>,
    val app_key: List<String>,
    val health: List<String>,
    val q: List<String>,
    val sane: List<Any>
)