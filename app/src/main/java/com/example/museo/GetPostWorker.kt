package com.example.museo

import android.content.Context
import retrofit2.Call

class GetPostWorker(context: Context) {
    private var listener: ActionListenerCallback? = null
    private lateinit var response: Call<MuseumItem>

    fun doWork(callback: ActionListenerCallback){
        listener = callback



    }
}