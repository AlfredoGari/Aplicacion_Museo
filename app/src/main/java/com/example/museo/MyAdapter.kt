package com.example.museo

import android.net.sip.SipSession
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(private val newlist: ArrayList<ObjetoMuseo>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int, codigo: String)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_museo, parent, false)
        return MyViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newlist[position]
        Picasso.get().load(currentItem.image).into(holder.image)
        holder.title.text = currentItem.nameOnjeto
        holder.header.text = currentItem.descripcionObjeto
        holder.codigo.text = currentItem.codigo
    }

    override fun getItemCount(): Int {
        return newlist.size
    }

    class MyViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.findViewById(R.id.textoN)
        val header : TextView = itemView.findViewById(R.id.textoF)
        val image : ImageView = itemView.findViewById(R.id.imagen)
        val codigo : TextView = itemView.findViewById(R.id.codigoo)

        init {

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition, codigo.text.toString())
            }
        }
    }
}