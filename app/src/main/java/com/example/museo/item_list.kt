package com.example.museo

import com.google.gson.annotations.SerializedName

data class item_list(

    @SerializedName("items_list")
    val items_list: List<ItemsGallery>

)

data class ItemsGallery(
    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("descripcion")
    val descripcion: String,

    @SerializedName("url")
    val url: String
)