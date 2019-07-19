package com.azure.foodfinder.demasClases

data class Sub(
    val daily: Int,
    val hasRDI: Boolean,
    val label: String,
    val schemaOrgTag: String,
    val tag: String,
    val total: Int,
    val unit: String
)