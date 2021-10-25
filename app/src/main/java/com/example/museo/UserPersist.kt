package com.example.museo

import android.app.Application

class UserPersist: Application() {

    companion object{
        lateinit var pref:Pref
    }

    override fun onCreate() {
        super.onCreate()
        pref =  Pref(applicationContext)
    }
}