package com.example.museo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.museo.databinding.ActivityItemMuseoBinding

class Item_museo : AppCompatActivity() {

    private lateinit var binding : ActivityItemMuseoBinding

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