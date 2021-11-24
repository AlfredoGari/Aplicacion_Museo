package com.example.museo

import android.content.Context
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.museo.databinding.ActivityItemMuseoBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

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
        var id: Int
        id = intent.getSerializableExtra("id") as Int


        callService(codigo, id)
    }
    private fun callService(codigo: String, id: Int){

            worker.doWork(object : ActionListenerCallback {
                override fun onActionSuccess(successMessage: MuseumItem) {
                    Log.i("Success", successMessage.toString())
                    binding.progressBar.visibility= View.GONE
                    Picasso.get().load(successMessage.item_main_picture).into(binding.imagenfoto)
                    binding.imagenfoto.isVisible =true
                    binding.title.text = successMessage.item_title
                    binding.title.isVisible = true
                    binding.descripcion.text = successMessage.item_intro
                    binding.descripcion.isVisible = true
                    binding.hsv.isVisible = true
                    binding.sv.isVisible = true
                    binding.fav.isVisible = true
                    binding.eli.isVisible = true
                    Picasso.get().load(successMessage.item_gallery[0].url).into(binding.imagen1)
                    Picasso.get().load(successMessage.item_gallery[1].url).into(binding.imagen2)
                    Picasso.get().load(successMessage.item_gallery[2].url).into(binding.imagen3)
                    Picasso.get().load(successMessage.item_main_picture).into(binding.imagen4)

                    binding.fav.setOnClickListener {
                        guardar(id, codigo, successMessage.item_main_picture, successMessage.item_title, successMessage.item_intro)
                        finish()
                    }
                    binding.eli.setOnClickListener {
                        eliminar(id, codigo)
                    }
                    binding.imagen1.setOnClickListener{
                        Picasso.get().load(successMessage.item_gallery[0].url).into(binding.imagenfoto)
                    }
                    binding.imagen2.setOnClickListener{
                        Picasso.get().load(successMessage.item_gallery[1].url).into(binding.imagenfoto)
                    }
                    binding.imagen3.setOnClickListener{
                        Picasso.get().load(successMessage.item_gallery[2].url).into(binding.imagenfoto)
                    }
                    binding.imagen4.setOnClickListener{
                        Picasso.get().load(successMessage.item_main_picture).into(binding.imagenfoto)
                    }

                }

                override fun onActionFailure(throwableError: Throwable) {
                    Log.i("Failure", throwableError.message.toString())
                }

            }, codigo)



    }
    fun guardar(id: Int, codigo: String, url: String, title: String, intro:String){

        val database = AppDataBase.getDatabase(this)


        lifecycleScope.launch(Dispatchers.IO){
            val favorito: Favorito
            favorito = Favorito(id,codigo, url, title, intro)
            //database.favoritos().verificar(id,codigo).codigo
            database.favoritos().insertAll(favorito)


        }
        Toast.makeText(this, "Favorito Guardado", Toast.LENGTH_SHORT).show()
    }

    fun eliminar(id: Int, codigo: String){
        val database = AppDataBase.getDatabase(this)
        lifecycleScope.launch(Dispatchers.IO){
            database.favoritos().eliminar(id, codigo)
        }
        Toast.makeText(this, "Favorito Eliminado", Toast.LENGTH_SHORT).show()
    }
}