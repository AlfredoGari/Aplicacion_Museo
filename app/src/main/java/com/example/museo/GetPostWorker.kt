package com.example.museo

import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.system.exitProcess

class GetPostWorker(context: Context) {

    private var listener: ActionListenerCallback? = null

    private lateinit var response: Call<MuseumItem>

    fun doWork(callback: ActionListenerCallback, codigo:String){

        listener = callback

        val museumService = NetworkingImplementation().service
        if(codigo=="1234567890"){
            response = museumService.getMuseumItem()
        }
        if(codigo=="01"){
            response = museumService.getMuseumItemDavid()
        }

        response.enqueue(object : Callback<MuseumItem> {
            override fun onResponse(call: Call<MuseumItem>, response: Response<MuseumItem>) {
                response.body()?.let {
                    callback.onActionSuccess(it)
                }
            }

            override fun onFailure(call: Call<MuseumItem>, t: Throwable) {
                callback.onActionFailure(t)
            }

        })

    }
}