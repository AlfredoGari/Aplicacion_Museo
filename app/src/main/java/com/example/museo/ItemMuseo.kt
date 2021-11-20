package com.example.museo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.museo.databinding.ActivityItemMuseoBinding
import com.squareup.picasso.Picasso

class ItemMuseo : AppCompatActivity() {

    private lateinit var binding: ActivityItemMuseoBinding

    private val worker: GetPostWorker = GetPostWorker(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemMuseoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var codigo: String
        codigo = intent.getStringExtra("codigo").toString()
        Toast.makeText(this, codigo,Toast.LENGTH_SHORT).show()

        callService()
    }
    private fun callService(){
        worker.doWork(object : ActionListenerCallback {
            override fun onActionSuccess(successMessage: MuseumItem) {
                Log.i("Success", successMessage.toString())
                Picasso.get().load(successMessage.item_main_picture).into(binding.imagenfoto)
                binding.title.text = successMessage.item_title
                binding.descripcion.text = successMessage.item_intro

            }

            override fun onActionFailure(throwableError: Throwable) {
                Log.i("Failure", throwableError.message.toString())
            }

        })

    }
}