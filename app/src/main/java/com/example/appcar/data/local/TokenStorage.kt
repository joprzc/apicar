package com.example.appcar.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
//import com.example.appcar.data.network.ApiClient
import com.example.appcar.data.models.LoginRequest
import com.example.appcar.data.models.RefreshRequest
import com.example.appcar.data.network.RetrofitClient
import kotlinx.coroutines.flow.first
import kotlin.collections.firstOrNull

private val Context.dataStore by preferencesDataStore(name = "auth_storage")

class TokenStorage(private val context: Context) {

    private val KEY_ACCESS = stringPreferencesKey("access_token")
    private val KEY_REFRESH = stringPreferencesKey("refresh_token")

    suspend fun loginAndLoad() {
        val token = RetrofitClient.api.login(LoginRequest(username = "adminapi", password = "admin2"))
//        val res = ApiClient.api.refresh(RefreshRequest(refreshToken))

//        RetrofitClient.setAccessToken(token.access)
//        saveTokens(token.access, token.refresh)

        val vehiculos = RetrofitClient.api.getVehiculos()
//        val vehiculo = vehiculos.firstOrNull() ?: return
//        val dashboard = ApiClient.api.getDashboard(vehiculo.vehicle_code)
    }

    suspend fun saveTokens(access: String, refresh: String) {
        context.dataStore.edit { prefs ->
            prefs[KEY_ACCESS] = access
            prefs[KEY_REFRESH] = refresh
        }
    }

    suspend fun getAccessToken(): String? {
        val prefs = context.dataStore.data.first()
        return prefs[KEY_ACCESS]
    }

    suspend fun getRefreshToken(): String? {
        val prefs = context.dataStore.data.first()
        return prefs[KEY_REFRESH]
    }

    suspend fun clear() {
        context.dataStore.edit { it.clear() }
    }
}