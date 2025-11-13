package com.example.androidprojectbloodbank

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class DonorFindHospitalsActivity : AppCompatActivity() {

    private lateinit var spinnerLocation: Spinner
    private lateinit var btnSearchHospitals: Button
    private lateinit var btnContactJustDialHospitals: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor_find_hospitals)

        spinnerLocation = findViewById(R.id.spinnerLocation)
        btnSearchHospitals = findViewById(R.id.btnSearchHospitals)
        btnContactJustDialHospitals = findViewById(R.id.btnContactJustDialHospitals)

        // 1️⃣ Setup Spinner Adapter
        val locations = arrayOf("Select Location", "Chennai", "Vellore", "Chittoor", "Bangalore")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, locations)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerLocation.adapter = adapter

        // 2️⃣ Handle Search Button
        btnSearchHospitals.setOnClickListener {
            val selectedLocation = spinnerLocation.selectedItem.toString()
            if (selectedLocation == "Select Location") {
                // Show a message or do nothing
            } else {
                // TODO: Implement hospital search by selectedLocation
            }
        }

        // 3️⃣ Open JustDial
        btnContactJustDialHospitals.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.justdial.com/Vellore/Hospitals/nct-10253670")
            startActivity(intent)
        }
    }
}
