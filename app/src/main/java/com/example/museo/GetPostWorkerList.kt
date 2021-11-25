package com.example.museo

import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetPostWorkerList(context: Context) {

    private var listener: ActionListenerCallbackList? = null

    private lateinit var response: Call<item_list>

    fun doWork(callback: ActionListenerCallbackList){
        listener = callback
        val museumService = NetworkingImplementation().service
        response = museumService.getMuseumItems()

        response.enqueue(object : Callback<item_list>{
            override fun onResponse(call: Call<item_list>, response: Response<item_list>) {
                response.body()?.let {
                    callback.onActionSuccess(it)
                }
            }

            override fun onFailure(call: Call<item_list>, t: Throwable) {
                callback.onActionFailure(t)
            }

        })
    }

}