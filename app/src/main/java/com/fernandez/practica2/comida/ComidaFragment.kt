package com.fernandez.practica2.comida
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.fernandez.practica2.MapsActivity
import com.fernandez.practica2.R
import kotlinx.android.synthetic.main.fragment_comidas.*


class ComidaFragment: Fragment() {
    private val listComida = listOf(
        Comida("Pizza DMarco","Pizzas","S/25.00","La mejor pizza con la combinación perfecta de queso, espinaca y carnes del norte trujillano",R.drawable.imagen1),
        Comida("Pan con Pollo","Sanguches","S/15.00","El tradicional pan con pollo trujillano, solo en DMarco",R.drawable.imagen2),
        Comida("Duo DMarco","Bebidas","S/15.00","La combinacion perfecta para compartir entre amigos",R.drawable.imagen3),
        Comida("Cafe","Bebidas","S/10.00","Los mejores granos del norte peruano solo en DMarco",R.drawable.imagen4),
        Comida("Ceviche","Pescado","S/35.00","La mejor pizza con la combinación perfecta de queso, espinaca y carnes del norte trujillano",R.drawable.imagen5),
    )

    companion object{
        fun newInstance(): ComidaFragment = ComidaFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comidas,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerComida.apply {
            layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
            adapter= ComidaAdapter(listComida)
        }

        floatingMessage.setOnClickListener{
            val editProfileIntent = Intent(getActivity(), MapsActivity::class.java)
            getActivity()?.startActivity(editProfileIntent)
        }
    }


}