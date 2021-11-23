package com.example.museo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.museo.databinding.ActivityHomeBinding
import com.example.museo.databinding.FragmentEditUsuarioBinding
import com.google.zxing.integration.android.IntentIntegrator

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id: Int
        id = intent.getSerializableExtra("id") as Int



        binding.qr.setOnClickListener{
            initScanner()
        }

        binding.list.setOnClickListener{
            val intent:Intent = Intent(this, ListadoMuseo::class.java)
            intent.putExtra("id",id)
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
        val codigo: String
        if(result != null){
            if(result.contents ==null){

            }else{
                codigo = result.contents
                val intent: Intent = Intent(this, ItemMuseo::class.java)
                intent.putExtra("codigo", codigo)
                startActivity(intent)
            }

        }else{

            super.onActivityResult(requestCode, resultCode, data)

        }



    }
}