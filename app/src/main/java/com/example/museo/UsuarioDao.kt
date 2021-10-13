package com.example.museo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM usuarios")
    fun getAll(): LiveData<List<Usuario>>

    @Query("SELECT * FROM usuarios WHERE usua = :usuar")
    fun get(usuar: String): LiveData<Usuario>

    @Insert
    fun insertAll(vararg usuarios: Usuario)

    @Update
    fun update(usuarios: Usuario)

}