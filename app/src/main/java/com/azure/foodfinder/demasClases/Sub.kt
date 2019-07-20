package com.azure.foodfinder.demasClases

import java.io.Serializable

data class Sub(
    val daily: Float,
    val hasRDI: Boolean,
    val label: String,
    val schemaOrgTag: String,
    val tag: String,
    val total: Float,
    val unit: String
):Serializable