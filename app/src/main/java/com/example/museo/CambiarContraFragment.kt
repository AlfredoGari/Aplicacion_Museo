package com.example.museo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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

            lifecycleScope.launch(Dispatchers.IO){
                val usar: Usuario
                usar = database.usuarios().getU(myuser.text.toString())
                if(usar==null){

                }else{

                }
            }




        }
    }




}
