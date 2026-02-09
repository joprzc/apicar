package com.example.appcar.data.models
import android.R
import com.google.gson.annotations.SerializedName

data class LoginRequest(
    val username: String,
    val password: String
)

data class TokenResponse(
    val access: String,
    val refresh: String
//    @SerializedName("access")
//    val access: String,
//    @SerializedName("refresh")
//    val refresh: String
)

data class RefreshRequest(
    val refresh: String
)

data class AccessTokenResponse(
    val access: String
)

//data class VehiculoDto(
////    val id: Int,
//    val anio: R.string,
//    val marca: String,
//    val modelo: String,
////    val placa: String,
//    @SerializedName("vehicle_code") val vehicle_code: String,
//    val tipo_comsbustible: String,
//)



