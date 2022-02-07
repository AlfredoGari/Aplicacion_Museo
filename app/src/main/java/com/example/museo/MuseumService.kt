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

    @GET("v1/4d9a1089-eb53-4b44-a4ad-39e2e96e34ee")
    fun getMuseumItems(): Call<item_list>

    @GET("v1/2bb7c731-6d7d-4de8-8580-791149c5177e")
    fun getMuseumItemLaGioconda(): Call<MuseumItem>

    @GET("v1/e8df4ad2-f4a2-4a1c-973f-ed24c39f31b7")
    fun getMuseumItemElGuernica(): Call<MuseumItem>

    @GET("v1/b1be7571-a2c2-47e6-8ead-b7ab01c3c8e8")
    fun getMuseumItemLaPersistencia(): Call<MuseumItem>
}