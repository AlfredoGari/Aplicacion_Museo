package com.example.museo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.museo.databinding.ActivityItemMuseoBinding

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
            }

            override fun onActionFailure(throwableError: Throwable) {
                Log.i("Failure", throwableError.message.toString())
            }

        })

    }
}