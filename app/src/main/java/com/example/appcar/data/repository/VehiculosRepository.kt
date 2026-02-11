package com.example.appcar.data.repository

import com.example.appcar.data.models.MantenimientoCreateRequest
import com.example.appcar.data.models.MantenimientoDto
import com.example.appcar.data.models.VehiculoDto
import com.example.appcar.data.network.RetrofitClient
import retrofit2.http.GET

//import com.example.appcar.data.network.interceptors.ApiService



class VehiculosRepository {

    private val api = RetrofitClient.api

    suspend fun getVehiculos(): List<VehiculoDto> = api.getVehiculos()

    suspend fun crearMantenimiento(req: MantenimientoCreateRequest): MantenimientoDto {
        return api.crearMantenimiento(req)
    }
}

