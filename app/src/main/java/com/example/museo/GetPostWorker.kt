package com.example.museo

import android.content.Context

class GetPostWorker(context: Context) {

    private var listener: ActionListenerCallback? = null

    fun doWork(callback: ActionListenerCallback){

        listener = callback

    }
}