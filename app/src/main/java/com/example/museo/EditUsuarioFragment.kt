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
        user = Usuario("", "", "")
        var contenido: String
        contenido = ""
        if (usuar != null) {
            database.usuarios().get(usuar).observe(viewLifecycleOwner, Observer { user = it })
        }
        contenido = user.usua



        if(arguments != null){
            val usuario = requireArguments().getString("usuario")
            val contra = requireArguments().getString("contraseña")
            val email = requireArguments().getString("email")
            val et: EditText = binding.userchange
            val et1: EditText = binding.emailchange
            val et2: EditText = binding.contrachange
            with(et) {
                setText(contenido)
            }
            et1.setText(email)
            et2.setText(contra)
        }
    }


}