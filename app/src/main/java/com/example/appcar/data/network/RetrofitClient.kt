package com.example.appcar.data.network

import com.example.appcar.data.local.TokenStorage
//import com.example.appcar.data.network.interceptors.ApiService
//import com.example.appcar.data.network.interceptors.AuthInterceptor
import com.example.appcar.data.network.interceptors.JwtInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:8000/" // emulador
//    private const val BASE_URL = "http://127.0.0.1:8000" // emulador
//    private var accessToken: String? = null

//    fun setAccessToken(token: String) { accessToken = token }
//
//    private val client = OkHttpClient.Builder()
//        .addInterceptor(JwtInterceptor { accessToken })
//        .build()
//
//    val api: ApiService = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .client(client)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//        .create(ApiService::class.java)
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}

