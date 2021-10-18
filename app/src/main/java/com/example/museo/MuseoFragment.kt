package com.example.museo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.example.museo.databinding.FragmentMuseoBinding
import com.example.museo.databinding.ItemMuseoBinding


class MuseoFragment : Fragment() {

    private lateinit var binding: FragmentMuseoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMuseoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(arguments != null){
            val usuario = requireArguments().getString("usuario")
            val et: TextView = binding.bienvenida
            et.setText("Bienvenido/a " + usuario)
        }
    }


}