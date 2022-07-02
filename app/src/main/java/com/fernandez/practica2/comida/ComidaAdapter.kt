package com.fernandez.practica2.comida
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ComidaAdapter(val list: List<Comida>):RecyclerView.Adapter<ComidaViewHolder>() {

    override fun getItemCount(): Int =list.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComidaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ComidaViewHolder(inflater,parent)
    }
    override fun onBindViewHolder(holder: ComidaViewHolder, position: Int) {
        val comida=list[position]
        holder.bind(comida)
    }
}