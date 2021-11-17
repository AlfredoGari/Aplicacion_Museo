package com.example.museo

import retrofit2.Call
import retrofit2.http.GET

interface MuseumService {

    @GET("v1/85d18fda-1cbf-4c73-a82b-063124586a44")
    fun getMuseumItem(): Call<MuseumItem>
}