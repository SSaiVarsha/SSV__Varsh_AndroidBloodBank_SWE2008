package com.example.androidprojectbloodbank

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class DonorMyDonationsActivity : AppCompatActivity() {

    private lateinit var lvMyDonations: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor_my_donations)

        lvMyDonations = findViewById(R.id.lvMyDonations)

        val donations = arrayOf(
            "A+ - Sai Varsha - 05 Nov 2025",
            "B+ - Sanjana G - 12 Oct 2025",
            "O+ - Rahul Kumar - 01 Sep 2025"
        )

        lvMyDonations.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            donations
        )
    }
}
