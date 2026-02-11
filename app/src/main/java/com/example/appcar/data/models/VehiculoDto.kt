package com.example.appcar.data.models

data class MantenimientoDto(
    val id: Int? = null,
    val vehiculo: Int? = null,
    val fecha: String? = null,
    val tipo: String? = null,
    val descripcion: String? = null
)

data class VehiculoDto(
    val id: Int? = null,
    val marca: String? = null,
    val modelo: String? = null,
    val anio: Int? = null,
    val placa: String? = null,
    val tipo_combustible: String? = null,
    val mantenimientos: List<MantenimientoDto> = emptyList()
)