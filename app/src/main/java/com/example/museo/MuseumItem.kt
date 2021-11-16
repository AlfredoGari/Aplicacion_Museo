package com.example.museo

import com.google.gson.annotations.SerializedName


data class MuseumItem (

    @SerializedName("id")
    val id: String,

    @SerializedName("item_title")
    val item_title: String,

    @SerializedName("room_name")
    val room_name: String,

    @SerializedName("item_intro")
    val item_intro: String,

    @SerializedName("item_main_content")
    val item_main_content: String,

    @SerializedName("item_main_picture")
    val item_main_picture: String,


        )