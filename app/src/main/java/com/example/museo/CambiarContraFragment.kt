package com.example.museo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation

class CambiarContraFragment: Fragment() {

    private lateinit var myboton: Button
    private lateinit var myuser: EditText
    private lateinit var mypassword: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contrasena, container, false)
        myboton = view.findViewById(R.id.buttonnn)
        myuser = view.findViewById(R.id.inputlayout2)
        mypassword = view.findViewById(R.id.inputlayout)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myboton.setOnClickListener{



            val database = AppDataBase.getDatabase(requireContext())
            var listaUsuarios = emptyList<Usuario>()
            var ver: Boolean

            database.usuarios().getAll().observe(viewLifecycleOwner,
                Observer {
                    listaUsuarios=it
                    ver=verificar(listaUsuarios, view)

                })


        }
    }

    fun verificar(listado: List<Usuario>, view: View): Boolean{

        var usuar: String
        var contador: Int
        var verif: Boolean

        verif = false
        contador = 0

        for(i in listado){

            usuar = listado[contador].usua

            if(usuar==myuser.text.toString()){
                verif = true
                Toast.makeText(requireContext(), "Cambiando contraseña...", Toast.LENGTH_SHORT).show()
            }else{


            }
            contador = contador +1
        }

        if(verif==true){
            val directions = CambiarContraFragmentDirections.actionCambiarContraFragmentToConfirmacionFragment()
            Navigation.findNavController(view).navigate(directions)
        }else{
            Toast.makeText(requireContext(), "No se encontro", Toast.LENGTH_SHORT).show()
        }
        return verif

    }


}