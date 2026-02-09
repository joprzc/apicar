package com.example.appcar.data.repository

import com.example.appcar.data.local.TokenStorage
import com.example.appcar.data.models.LoginRequest
import com.example.appcar.data.models.RefreshRequest
import com.example.appcar.data.network.ApiService

class AuthRepository(
    private val api: ApiService,
    private val tokenStorage: TokenStorage
) {
    suspend fun login(username: String, password: String) {
        val res = api.login(LoginRequest(username, password))
        // login devuelve access + refresh
        tokenStorage.saveTokens(res.access, res.refresh ?: "")
    }

    suspend fun refreshAccessToken(): String {
        val refresh = tokenStorage.getRefreshToken()
            ?: throw IllegalStateException("No hay refresh token guardado")

        val res = api.refresh(RefreshRequest(refresh))
        // SimpleJWT normalmente devuelve SOLO `access` en refresh.
        // Guardamos el nuevo access y mantenemos el refresh existente.
        tokenStorage.saveTokens(res.access, refresh)
        return res.access
    }
}
