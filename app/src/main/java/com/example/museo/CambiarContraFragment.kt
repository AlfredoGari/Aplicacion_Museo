package com.example.museo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class CambiarContraFragment: Fragment() {

    private lateinit var myboton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contrasena, container, false)
        myboton = view.findViewById(R.id.buttonnn)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myboton.setOnClickListener{

            val database = AppDataBase.getDatabase(this)

            var listaUsuarios = emptyList<Usuario>()

            dataBase.usuarios().getAll().observe(this, Observer {
                listaUsuarios = it
            })

            val directions = CambiarContraFragmentDirections.actionCambiarContraFragmentToConfirmacionFragment()
            Navigation.findNavController(view).navigate(directions)
        }
    }

}