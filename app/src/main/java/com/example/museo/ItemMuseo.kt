package com.example.museo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.museo.databinding.ActivityItemMuseoBinding

class ItemMuseo : AppCompatActivity() {

    private lateinit var binding: ActivityItemMuseoBinding

    private val worker: GetPostWorker = GetPostWorker(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemMuseoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        callService()
    }
    private fun callService(){

    }
}