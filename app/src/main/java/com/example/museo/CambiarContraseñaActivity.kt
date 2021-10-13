package com.example.museo

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.museo.databinding.ActivityContrasenaBinding


class CambiarContraseñaActivity: AppCompatActivity() {

    private lateinit var binding: ActivityContrasenaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContrasenaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}