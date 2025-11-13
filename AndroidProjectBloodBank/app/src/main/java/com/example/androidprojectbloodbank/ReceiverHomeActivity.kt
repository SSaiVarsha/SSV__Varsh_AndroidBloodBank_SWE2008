package com.example.androidprojectbloodbank

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ReceiverHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver_home)

        // Top buttons
        findViewById<Button>(R.id.btnNearbyDonors).setOnClickListener {
            startActivity(Intent(this, NearbyDonorsActivity::class.java))
        }
        findViewById<Button>(R.id.btnFindBloodBanks).setOnClickListener {
            startActivity(Intent(this, FindBloodBanksActivity::class.java))
        }
        findViewById<Button>(R.id.btnFindHospitals).setOnClickListener {
            startActivity(Intent(this, FindHospitalsActivity::class.java))
        }
        findViewById<Button>(R.id.btnNotificationLabel).setOnClickListener {
            // Open Receiver Notifications Page
            startActivity(Intent(this, NotificationsActivity::class.java))
        }

        // Bottom nav buttons
        findViewById<Button>(R.id.btnHome).setOnClickListener { /* Already on Home */ }
        findViewById<Button>(R.id.btnFindDonor).setOnClickListener {
            startActivity(Intent(this, NearbyDonorsActivity::class.java))
        }
        findViewById<Button>(R.id.btnRequests).setOnClickListener {
            startActivity(Intent(this, RequestsActivity::class.java))
        }
        findViewById<Button>(R.id.btnProfile).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}
