package com.example.androidprojectbloodbank

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class DonorAvailableRequestsActivity : AppCompatActivity() {

    private lateinit var lvAvailableRequests: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor_available_requests)

        lvAvailableRequests = findViewById(R.id.lvAvailableRequests)

        // Sample data
        val requests = arrayOf(
            "Sai varsha - A+ - Chennai",
            "Sanjana G - B+ - Chittoor",
            "Rahul Kumar - O+ - Bangalore"
        )

        lvAvailableRequests.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            requests
        )
    }
}
