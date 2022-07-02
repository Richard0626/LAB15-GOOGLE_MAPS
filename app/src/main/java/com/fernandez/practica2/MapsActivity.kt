package com.fernandez.practica2

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        title = "D'Marco Localizacion"
        createMapFragment()
    }

    private fun createMapFragment(){
        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragmentMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap){
        try {
            val success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    this, R.raw.stylemap
                )
            )
            if(success){ Log.v("GOOGLE_MAPS", "Cargo correctamente")
            } else{ Log.v("GOOGLE_MAPS", "No cargo correctamente")
            }
        }catch (e: Resources.NotFoundException){
            Log.v("GOOGLE_MAPS", "Error: ", e)
        }
        // Marcador
        val posicionMarkerDMarco = LatLng(-8.109088,-79.025550)
        googleMap.addMarker(
            MarkerOptions().position(posicionMarkerDMarco)
                .title("D'Marco - 1956 ")
                .snippet("CAFETERIA - PASTELERIA")

        )
        googleMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(posicionMarkerDMarco, 22F),
            2000,
            null
        )
        googleMap.uiSettings.isZoomControlsEnabled = true
        googleMap.uiSettings.isRotateGesturesEnabled = false
    }
}