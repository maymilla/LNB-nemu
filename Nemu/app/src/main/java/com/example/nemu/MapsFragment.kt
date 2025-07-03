package com.example.nemu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment(R.layout.fragment_maps) {

    private lateinit var googleMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map_fragment) as SupportMapFragment

        mapFragment.getMapAsync { map ->
            googleMap = map
            val location = LatLng(-6.914744, 107.609810) // Example: Bandung
            googleMap.addMarker(MarkerOptions().position(location).title("Bandung"))
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 14f))
        }

        view.findViewById<TextView>(R.id.place_name_2).text = "Birmingham Museum"
        view.findViewById<TextView>(R.id.place_address_2).text = "Jl. Melati No. 5"
    }
}
