package com.example.museo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.museo.databinding.FragmentEditUsuarioBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class EditUsuarioFragment : Fragment() {

    private lateinit var nombre:String
    private lateinit var unmail:String
    private lateinit var contrasena:String
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
        val et: EditText = binding.userchange
        val et1: EditText = binding.emailchange
        val et2: EditText = binding.contrachange
        binding.actusu.setOnClickListener {

            if(binding.userchange.text.toString()==nombre){

                if(binding.emailchange.text.toString()!=unmail){

                    Toast.makeText(context, R.string.nmm, Toast.LENGTH_SHORT ).show();
                    et.setText(nombre)
                    et1.setText(unmail)
                    et2.setText(contrasena)

                }else{

                    if(binding.emailchange.text.toString().contains("@")){

                        if(binding.contrachange.text.toString()==""){

                            Toast.makeText(context, R.string.nc, Toast.LENGTH_SHORT ).show();
                            et.setText(nombre)
                            et1.setText(unmail)
                            et2.setText(contrasena)

                        }else{

                        if(binding.contrachange.text.toString().length < 8){

                            Toast.makeText(context, R.string.ncc, Toast.LENGTH_SHORT ).show();
                            et.setText(nombre)
                            et1.setText(unmail)
                            et2.setText(contrasena)

                        }else{

        val database = AppDataBase.getDatabase(requireContext())
            lifecycleScope.launch(Dispatchers.IO){
                database.usuarios().cambiat(binding.contrachange.text.toString(),binding.userchange.text.toString())
            }
                            nombre = binding.userchange.text.toString()
                            contrasena = binding.contrachange.text.toString()
                Toast.makeText(context, R.string.cg, Toast.LENGTH_SHORT ).show();

                        }

                       }

                }else{

                        Toast.makeText(context, R.string.nmv, Toast.LENGTH_SHORT ).show();
                        et.setText(nombre)
                        et1.setText(unmail)
                        et2.setText(contrasena)

                    }

                }

            }else{
                Toast.makeText(context, R.string.nm, Toast.LENGTH_SHORT ).show();
                et.setText(nombre)
                et1.setText(unmail)
                et2.setText(contrasena)
            }

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
            nombre = user.usua
            unmail = user.ema
            contrasena = user.contr
        }
    }
}