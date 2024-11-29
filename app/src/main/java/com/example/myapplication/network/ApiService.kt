package com.example.myapplication.network

import com.example.myapplication.model.Pokemon
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
interface ApiService {
    @GET("pokemon")
    suspend fun  getAllPokemon():List<Pokemon>

}

private var BASE_URL="https://tyradex.vercel.app/api/v1/"

private val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create()) // For JSON parsing
    .baseUrl(BASE_URL)
    .build()
object PockApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }}