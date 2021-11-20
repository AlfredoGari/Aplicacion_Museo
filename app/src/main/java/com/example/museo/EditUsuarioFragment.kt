package com.example.museo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.Observer
import com.example.museo.databinding.FragmentEditUsuarioBinding


class EditUsuarioFragment : Fragment() {

    private lateinit var binding: FragmentEditUsuarioBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditUsuarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val database = AppDataBase.getDatabase(requireContext())
        val usuar = requireArguments().getString("usuario")
        var user: Usuario
        user = Usuario("lfdlf", "ddffm", "kdf")
        var contenido: String
        contenido = ""
        if (usuar != null) {

            database.usuarios().get(usuar).observe(viewLifecycleOwner,
                Observer {
                    user = it
                    contenido = it.usua
                    actualizar(user)
                })

        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.actusu.setOnClickListener {

        //    val database = AppDataBase.getDatabase(requireContext())
        //    database.usuarios().cambiat(binding.contrachange.text.toString(),binding.userchange.text.toString())

        }

    }

    fun actualizar(user: Usuario){
        if(arguments != null){
            val et: EditText = binding.userchange
            val et1: EditText = binding.emailchange
            val et2: EditText = binding.contrachange
            et.setText(user.usua)
            et1.setText(user.ema)
            et2.setText(user.contr)
        }

    }


}