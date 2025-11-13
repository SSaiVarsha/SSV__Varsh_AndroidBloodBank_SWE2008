package com.example.androidprojectbloodbank

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class DonorFindCentersActivity : AppCompatActivity() {

    private lateinit var spinnerLocation: Spinner
    private lateinit var btnSearchCenters: Button
    private lateinit var btnContactJustDial: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor_find_centers)

        spinnerLocation = findViewById(R.id.spinnerLocation)
        btnSearchCenters = findViewById(R.id.btnSearchCenters)
        btnContactJustDial = findViewById(R.id.btnContactJustDial)

        // 1️⃣ Setup Spinner Adapter
        val locations = arrayOf("Select Location", "Chennai", "Vellore", "Chittoor", "Bangalore")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, locations)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerLocation.adapter = adapter

        // 2️⃣ Handle Search Button
        btnSearchCenters.setOnClickListener {
            val selectedLocation = spinnerLocation.selectedItem.toString()
            if (selectedLocation == "Select Location") {
                // Show message or do nothing
            } else {
                // TODO: Implement search by selectedLocation
            }
        }

        // 3️⃣ Open JustDial
        btnContactJustDial.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.justdial.com/Vellore/Blood-Banks/nct-10049054")
            startActivity(intent)
        }
    }
}
