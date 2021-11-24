package com.example.museo

import retrofit2.Call
import retrofit2.http.GET

interface MuseumService {

    @GET("v1/85d18fda-1cbf-4c73-a82b-063124586a44")
    fun getMuseumItem(): Call<MuseumItem>

    @GET("v1/91e79d0c-1bcb-449a-b740-28a285c928c3")
    fun getMuseumItemDavid(): Call<MuseumItem>

    @GET("v1/65169173-ca4b-4229-aa6b-fa4857764477")
    fun getMuseumItemLasSenoritas(): Call<MuseumItem>

    @GET("v1/12ea80dd-5244-4dad-9c5e-9efb4aaef4ed")
    fun getMuseumItemLanoche(): Call<MuseumItem>

    @GET("v1/07b7adf9-78b1-4625-9abe-6df68d68dac3")
    fun getMuseumItems(): Call<item_list>
}