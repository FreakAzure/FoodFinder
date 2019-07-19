package com.azure.foodfinder.dataClasses

import java.io.Serializable

data class Params(
    val app_id: List<String>,
    val app_key: List<String>,
    val healthLabels: List<String>,
    val q: List<String>,
    val sane: List<Any>
): Serializable