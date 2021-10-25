package com.example.museo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.room.Database
import com.example.museo.UserPersist.Companion.pref
import com.example.museo.databinding.ActivitySplashBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    var crear : TextView?= null
    var crear2 : TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkuser()

        var listaUsuarios = emptyList<Usuario>()

        val dataBase = AppDataBase.getDatabase(this)

        dataBase.usuarios().getAll().observe(this, Observer {
            listaUsuarios = it

        })



        crear = binding.label1
        crear2 = binding.label

        crear!!.setOnClickListener{
            val intent:Intent = Intent(this, Crear_usuario::class.java)
            startActivity(intent)
        }

        crear2!!.setOnClickListener{
            startActivity(Intent(this, CambiarContraseñaActivity::class.java))

        }
        binding.button.setOnClickListener{

            var contador: Int
            var usuar: String
            var contra: String

            contador = 0
            for(i in listaUsuarios){

                usuar = listaUsuarios[contador].usua
                contra = listaUsuarios[contador].contr

                if(usuar==binding.inputlayout2.text.toString() && contra==binding.inputlayout.text.toString()){
                    val persona: Usuario
                    persona = listaUsuarios[contador]
                    accessToDetail(persona)
                    val intent:Intent = Intent(this, navigation_user::class.java)
                    intent.putExtra("dato",persona)
                    startActivity(intent)
                    finish()
                }else{

                }

                contador = contador +1
            }




        }
    }
    fun accessToDetail(persona: Usuario){
        if(binding.checkBox.isChecked){
            pref.saveName(binding.inputlayout2.text.toString())
            pref.saveBool(binding.checkBox.isChecked)
            pref.saveCorreo(persona.ema)

        }
    }
    fun checkuser(){
        if(pref.getName().isNotEmpty()){
            gotoActivity()
        }
    }
    fun gotoActivity(){
        val intent:Intent = Intent(this, navigation_user::class.java)
        startActivity(intent)
        finish()
    }
}




