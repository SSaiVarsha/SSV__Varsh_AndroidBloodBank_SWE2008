package com.example.androidprojectbloodbank

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FindBloodBanksActivity : AppCompatActivity() {

    private lateinit var spinnerLocation: Spinner
    private lateinit var btnSearchBloodBanks: Button
    private lateinit var imgBloodBankMap: ImageView
    private lateinit var btnContactJustDial: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_blood_banks)

        spinnerLocation = findViewById(R.id.spinnerLocation)
        btnSearchBloodBanks = findViewById(R.id.btnSearchBloodBanks)
        btnContactJustDial = findViewById(R.id.btnContactJustDial)

        // Initialize Spinner
        val locations = arrayOf("Chittoor", "Vellore", "Chennai", "bangalore", "More")
        spinnerLocation.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, locations)

        // Search Button Click
        btnSearchBloodBanks.setOnClickListener {
            val selectedLocation = spinnerLocation.selectedItem.toString()
            Toast.makeText(this, "Showing blood banks in $selectedLocation", Toast.LENGTH_SHORT).show()

            // Show placeholder image (or you can load a dynamic map later)
            imgBloodBankMap.setImageResource(R.drawable.map_placeholder)
        }

        // Contact via JustDial Button Click
        btnContactJustDial.setOnClickListener {
            val selectedLocation = spinnerLocation.selectedItem.toString()
            val url = "https://www.justdial.com/Vellore/Blood-Banks/nct-10049054"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}
