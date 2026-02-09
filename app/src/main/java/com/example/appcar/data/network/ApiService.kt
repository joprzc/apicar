package com.example.appcar.data.network

import com.example.appcar.data.models.AccessTokenResponse
import com.example.appcar.data.models.DashboardDto
import com.example.appcar.data.models.LoginRequest
import com.example.appcar.data.models.RefreshRequest
import com.example.appcar.data.models.TokenResponse
import com.example.appcar.data.models.VehiculoDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    // Ajusta rutas según tu Django:
    @POST("api/token/")
    suspend fun login(@Body body: LoginRequest): TokenResponse

    @POST("api/token/refresh/")
    suspend fun refresh(@Body body: RefreshRequest): AccessTokenResponse

    @GET("api/dashboard/{vehicleCode}/")
    suspend fun getDashboard(@Path("vehicleCode") vehicleCode: String): DashboardDto

    // Ejemplo de endpoint protegido
    @GET("api/vehiculos/")
    suspend fun getVehiculos(): List<VehiculoDto>
}
