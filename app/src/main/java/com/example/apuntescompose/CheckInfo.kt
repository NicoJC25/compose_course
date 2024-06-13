package com.example.apuntescompose

//Creamos una data class que va a tener to-do lo necesario para crear la info de un checkbox
data class CheckInfo(
    val title: String,
    var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
)