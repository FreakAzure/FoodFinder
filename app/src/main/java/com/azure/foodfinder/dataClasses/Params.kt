package com.azure.foodfinder.dataClasses

data class Params(
    val app_id: List<String>,
    val app_key: List<String>,
    val healthLabels: List<String>,
    val q: List<String>,
    val sane: List<Any>
)