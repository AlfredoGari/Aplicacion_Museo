package com.example.museo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.museo.databinding.FragmentFavoriteBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FavoriteFragment : Fragment() {


    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    fun initRecycler(){
        val database = AppDataBase.getDatabase(requireContext())
        var listaf = emptyList<Favorito>()
        val listadoofav = arrayListOf<ObjetoMuseo>()
        var contador: Int
        val usuar: Int
        usuar = requireArguments().getInt("id_p")
        contador = 0
        database.favoritos().getAllF(usuar).observe(
            viewLifecycleOwner, Observer {
                listaf = it
                var objeto: ObjetoMuseo
                for(i in listaf){
                    objeto = ObjetoMuseo(listaf[contador].codigo, listaf[contador].title,
                    listaf[contador].descripcion, listaf[contador].urlImage)
                    listadoofav.add(objeto)
                    contador=contador+1
                }
                ini(listadoofav)
            }
        )

    }

    fun ini(listadoofav: ArrayList<ObjetoMuseo>){
        binding.rb.layoutManager = LinearLayoutManager(context)
        val adapter =MuseoAdapter(listadoofav)
        binding.rb.adapter = adapter
    }

}