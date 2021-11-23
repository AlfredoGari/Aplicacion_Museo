package com.example.museo

import retrofit2.Call
import retrofit2.http.GET

interface MuseumService {

    @GET("v1/85d18fda-1cbf-4c73-a82b-063124586a44")
    fun getMuseumItem(): Call<MuseumItem>

    @GET("v1/2a2c6c28-b790-49d4-a44c-d94a3f15f7a7")
    fun getMuseumItemDavid(): Call<MuseumItem>
}