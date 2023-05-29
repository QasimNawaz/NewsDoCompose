package com.qasimnawaz019.newsdocompose.ui.screens.country

data class Country(
    val name: String,
    val code: String,
    val icon: Int,
    var isSelected: Boolean = false
)
