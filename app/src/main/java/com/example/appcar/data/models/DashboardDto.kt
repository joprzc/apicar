package com.example.appcar.data.models

import com.google.gson.annotations.SerializedName

data class DashboardDto(
    val vehiculo: VehiculoDto,
    @SerializedName("obd_latest") val obdLatest: List<ObdDto> = emptyList(),
    val recomendaciones: List<RecomendacionDto> = emptyList()
)

//data class VehiculoDto(
//    val id: Int,
//    @SerializedName("vehicle_code") val vehicle_code: String,
//    val marca: String? = null,
//    val modelo: String? = null,
//    val color: String? = null
//)

data class ObdDto(
    val id: Int? = null,
    val vehicle_code: String? = null,
    val timestamp: String? = null,
    val engine_rpm: Double? = null,
    val vehicle_speed_kph: Double? = null,
    val engine_temp_c: Double? = null
)

data class RecomendacionDto(
    val id: Int? = null,
    val tipo: String? = null,
    val mensaje: String? = null,
    val severidad: String? = null,
    val fecha: String? = null,
    val estado: String? = null
)