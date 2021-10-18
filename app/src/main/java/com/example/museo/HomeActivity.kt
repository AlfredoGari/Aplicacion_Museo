package com.example.museo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.museo.databinding.ActivityHomeBinding
import com.example.museo.databinding.FragmentEditUsuarioBinding
import com.google.zxing.integration.android.IntentIntegrator

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.qr.setOnClickListener{
            initScanner()
        }

        binding.list.setOnClickListener{
            val intent:Intent = Intent(this, ListadoMuseo::class.java)
            startActivity(intent)
        }


    }

    private fun initScanner(){
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integrator.setPrompt("Escanea")
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
        if(result != null){
            if(result.contents ==null){

            }else{
                Toast.makeText(this, "El valor escaneado es: ${result.contents}", Toast.LENGTH_SHORT).show()
            }

        }else{

            super.onActivityResult(requestCode, resultCode, data)

        }



    }
}