package com.example.kotlin_mvvm_retrofit2.newtwork

import com.example.kotlin_mvvm_retrofit2.models.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("repositories")
    suspend fun getDataFromApi(@Query(value = "q") query: String) : RecyclerList
}