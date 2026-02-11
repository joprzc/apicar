package com.example.appcar.data.models

data class MantenimientoCreateRequest(
    val vehiculo: Int,
    val fecha: String,
    val tipo: String,
    val descripcion: String
)