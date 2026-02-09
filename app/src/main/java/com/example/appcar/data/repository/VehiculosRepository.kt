package com.example.appcar.data.repository

import com.example.appcar.data.models.VehiculoDto
import com.example.appcar.data.network.RetrofitClient

//import com.example.appcar.data.network.interceptors.ApiService



class VehiculosRepository {

    private val api = RetrofitClient.api

    suspend fun getVehiculos(): List<VehiculoDto> {
        return api.getVehiculos()
    }
}

