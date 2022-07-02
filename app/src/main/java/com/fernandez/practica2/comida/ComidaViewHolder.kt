package com.fernandez.practica2.comida
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fernandez.practica2.R

class ComidaViewHolder(inflater: LayoutInflater,parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_comidas, parent,false)) {
        private var imgComida:ImageView?=null
        private var textComidaTitle: TextView?=null
        private var textComidaPrecio: TextView?=null
        private var textComidaTipo: TextView?=null
        private var textComidaDescription: TextView? = null
        init {
            imgComida = itemView.findViewById(R.id.imgComidas)
            textComidaTitle = itemView.findViewById(R.id.textComidaTitle)
            textComidaTipo = itemView.findViewById(R.id.textComidaTipo)
            textComidaPrecio = itemView.findViewById(R.id.textComidaPrecio)
            textComidaDescription = itemView.findViewById(R.id.textComidaDescription)
        }
        fun bind(comida: Comida){
            textComidaTitle?.text=comida.title
            textComidaTipo?.text=comida.tipo
            textComidaPrecio?.text=comida.precio
            textComidaDescription?.text=comida.description
            imgComida?.setImageResource(comida.image)
        }
    }
