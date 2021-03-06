package com.example.museo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.museo.databinding.ActivityCrearUsuarioBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch

class Crear_usuario : AppCompatActivity() {

    private lateinit var binding: ActivityCrearUsuarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = AppDataBase.getDatabase(this)

        var listaUsuarios = emptyList<Usuario>()

        val dataBase = AppDataBase.getDatabase(this)

        dataBase.usuarios().getAll().observe(this, Observer {
            listaUsuarios = it

        })

        binding.crearusu.setOnClickListener{
            var usuar: String
            var contador: Int
            var verif: Boolean
            verif = false
            contador = 0


            for(i in listaUsuarios){

                usuar = listaUsuarios[contador].usua

                if(usuar==binding.inputlayout2.text.toString()){
                verif = true
                }else{

            }
                contador = contador +1
            }

            if(verif==true || binding.inputlayout2.text.toString()=="" || binding.inputlayout.text.toString()=="" || binding.inputlayout3.text.toString()==""){
                if(binding.inputlayout2.text.toString()=="" || binding.inputlayout3.text.toString()=="" || binding.inputlayout.text.toString()==""){
                    Toast.makeText(this, R.string.miss, Toast.LENGTH_SHORT ).show();
                }else{
                    Toast.makeText(this, R.string.existe, Toast.LENGTH_SHORT ).show();
                }

            }else{

                val user = binding.inputlayout2.text.toString()
                val correo = binding.inputlayout3.text.toString()
                val contra = binding.inputlayout.text.toString()
                verif = validar(user, correo, contra)
                val userfinal = Usuario(user,contra,correo)

                if(verif){

                    Toast.makeText(this, R.string.bn, Toast.LENGTH_SHORT ).show();

                CoroutineScope(Dispatchers.IO).launch {
                    database.usuarios().insertAll(userfinal)

                    this@Crear_usuario.finish()

                 }

                }


            }
        }
    }
    private fun validar(user: String, correo:String, contra:String): Boolean{
        var verr:Boolean
        verr=true
            if(user.length < 5){
                verr=false
                Toast.makeText(this, R.string.e1, Toast.LENGTH_SHORT ).show();
            }
            if(correo.contains("@")){
            }else{
                verr=false
                Toast.makeText(this, R.string.e2, Toast.LENGTH_SHORT ).show();
            }
            if(contra.length < 8){
                verr=false
                Toast.makeText(this, R.string.e3, Toast.LENGTH_SHORT ).show();
            }

        return verr
    }
}