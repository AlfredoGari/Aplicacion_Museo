package com.example.museo

import android.content.Context

class Pref(val context: Context) {
        val SHARED_NAME = "Mydtb"
        val SHARED_USER_NAME = "username"
        val SHARED_CORREO = "correo"
        val SHARED_BOL = "bol"


        val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveName(name:String){
        storage.edit().putString(SHARED_USER_NAME, name).apply()
    }

    fun saveBool(bol:Boolean){
        storage.edit().putBoolean(SHARED_BOL, bol)
    }

    fun saveCorreo(correo:String){
        storage.edit().putString(SHARED_CORREO, correo).apply()
    }

    fun getName():String{
        return storage.getString(SHARED_USER_NAME, "")!!
    }

    fun getCorreo():String{
        return storage.getString(SHARED_CORREO, "")!!
    }

    fun getBool():Boolean{
        return storage.getBoolean(SHARED_BOL, false)
    }

    fun wipe(){
        storage.edit().clear().apply()
    }

}