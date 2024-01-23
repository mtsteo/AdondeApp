package com.example.adondeapp

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.SupportMapFragment
import android.widget.SearchView

class MainActivity : AppCompatActivity() {

    private lateinit var searchView: SearchView
/*capitão poço LT LG -1.7443707,-47.0646394*/
    private val places = arrayListOf(
        Place("Google", LatLng(-1.7443707,-47.0646394), "Capitão Poço", 4.8f)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView = findViewById(R.id.searchView)
        var mapFragment = supportFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment

        mapFragment.getMapAsync{ googleMap: GoogleMap ->
            addMarker(googleMap)
        }

    }
    private fun addMarker(googleMap: GoogleMap){
        places.forEach { place ->
            var marker = googleMap.addMarker(
                MarkerOptions()
                    .title(place.name)
                    .snippet(place.address)
                    .position(place.latLng)
            )
        }

    }
}

data class Place(
    val name: String,
    val latLng: LatLng,
    val address : String,
    val rating : Float

)