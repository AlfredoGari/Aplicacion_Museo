package com.example.museo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkingImplementation {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://mocki.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: MuseumService = retrofit.create(MuseumService::class.java)
}