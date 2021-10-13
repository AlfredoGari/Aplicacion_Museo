package com.example.museo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "usuarios")
class Usuario (
    var usua:String,
    val contr:String,
    val ema:String,
    @PrimaryKey(autoGenerate = true)
    var idUsuario: Int = 0
    ) : Serializable