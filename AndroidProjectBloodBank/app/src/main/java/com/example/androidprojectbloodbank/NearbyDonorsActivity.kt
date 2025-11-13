package com.example.androidprojectbloodbank

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NearbyDonorsActivity : AppCompatActivity() {

    private lateinit var spinnerBloodType: Spinner
    private lateinit var spinnerLocation: Spinner
    private lateinit var btnSearchDonors: Button
    private lateinit var mapPlaceholder: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nearby_donors)

        spinnerBloodType = findViewById(R.id.spinnerBloodType)
        spinnerLocation = findViewById(R.id.spinnerLocation)
        btnSearchDonors = findViewById(R.id.btnSearchDonors)
        mapPlaceholder = findViewById(R.id.mapContainer) // ImageView placeholder

        // Initially hide the placeholder
        mapPlaceholder.visibility = ImageView.GONE

        // Initialize Spinners
        val bloodTypes = arrayOf("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-")
        val locations = arrayOf("Chittoor", "Vellore", "Chennai", "bangalore", "More") // Example locations

        spinnerBloodType.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, bloodTypes)
        spinnerLocation.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, locations)

        // Search Button
        btnSearchDonors.setOnClickListener {
            val selectedBlood = spinnerBloodType.selectedItem.toString()
            val selectedLocation = spinnerLocation.selectedItem.toString()
            searchNearbyDonors(selectedBlood, selectedLocation)
        }
    }

    private fun searchNearbyDonors(bloodType: String, location: String) {
        // Show Toast
        Toast.makeText(this, "Searching $bloodType donors in $location", Toast.LENGTH_SHORT).show()

        // Make placeholder visible
        mapPlaceholder.setImageResource(R.drawable.map_placeholder)
        mapPlaceholder.visibility = ImageView.VISIBLE
    }
}
