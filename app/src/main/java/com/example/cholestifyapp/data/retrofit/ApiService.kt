package com.example.cholestifyapp.data.retrofit

import com.example.cholestifyapp.data.response.ResponseFood
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("foods") // Sesuaikan endpoint dengan API Anda
    suspend fun getFoods(): Response<ResponseFood>

    companion object {
        private const val BASE_URL = "https://cholestify-service-326196240933.asia-southeast2.run.app/food/" // Ganti dengan URL API Anda

        fun create(): ApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}