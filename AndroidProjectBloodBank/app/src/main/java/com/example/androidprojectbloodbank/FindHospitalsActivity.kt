package com.example.androidprojectbloodbank

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FindHospitalsActivity : AppCompatActivity() {

    private lateinit var spinnerLocation: Spinner
    private lateinit var btnSearchHospitals: Button
    private lateinit var btnContactJustDial: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_hospitals)

        spinnerLocation = findViewById(R.id.spinnerLocation)
        btnSearchHospitals = findViewById(R.id.btnSearchHospitals)
        btnContactJustDial = findViewById(R.id.btnContactJustDial)

        // Sample locations
        val locations = arrayOf("Chittoor", "Vellore", "Chennai", "Bangalore", "More")
        spinnerLocation.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, locations)

        // Search Button click
        btnSearchHospitals.setOnClickListener {
            val location = spinnerLocation.selectedItem.toString()
            Toast.makeText(this, "Showing hospitals in $location", Toast.LENGTH_SHORT).show()
            // You can later integrate map or list results here
        }

        // JustDial contact click
        btnContactJustDial.setOnClickListener {
            val location = spinnerLocation.selectedItem.toString()
            val url = "https://www.justdial.com/Vellore/Hospitals/nct-10253670"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }}