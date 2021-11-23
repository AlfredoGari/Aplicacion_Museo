package com.example.museo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface FavoritoDao {

    @Query("SELECT * FROM favoritos WHERE idusuario = :idusuar")
    fun getAllF(idusuar:Int): LiveData<List<Favorito>>

    @Insert
    fun insertAll(vararg favoritos: Favorito)
}