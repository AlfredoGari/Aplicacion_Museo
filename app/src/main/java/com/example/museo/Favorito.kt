package com.example.museo

import androidx.room.Entity
import java.io.Serializable

@Entity(tableName = "favoritos")
class Favorito (

    val idusuario:String,
    val codigo:String,
    val urlImage:String,
    val title:String,
    val descripcion:String

        ) : Serializable

