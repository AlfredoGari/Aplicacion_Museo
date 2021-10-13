package com.example.museo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.museo.databinding.ItemMuseoBinding
import com.squareup.picasso.Picasso

class MuseoAdapter(val museo:List<ObjetoMuseo>):RecyclerView.Adapter<MuseoAdapter.MuseoHolder>() {

    class MuseoHolder(val view:View):RecyclerView.ViewHolder(view){
        val binding =ItemMuseoBinding.bind(view)
        fun render(museo: ObjetoMuseo){
            binding.textoN.text = museo.nameOnjeto
            binding.textoF.text = museo.descripcionObjeto
            Picasso.get().load(museo.image).into(binding.imagen)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuseoHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        return MuseoHolder(layoutInflater.inflate((R.layout.item_museo), parent, false))
    }

    override fun onBindViewHolder(holder: MuseoHolder, position: Int) {
        holder.render(museo[position])
    }

    override fun getItemCount(): Int {
        return museo.size
    }
}