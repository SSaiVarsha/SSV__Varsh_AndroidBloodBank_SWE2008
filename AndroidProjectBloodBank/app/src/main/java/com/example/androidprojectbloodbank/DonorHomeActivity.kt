package com.example.androidprojectbloodbank

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class DonorHomeActivity : AppCompatActivity() {

    private lateinit var btnNotification: ImageView
    private lateinit var btnNotificationLabel: Button
    private lateinit var btnAvailableRequests: Button
    private lateinit var btnFindCenters: Button
    private lateinit var btnFindHospitals: Button
    private lateinit var btnHome: Button
    private lateinit var btnFindRequests: Button
    private lateinit var btnDonations: Button
    private lateinit var btnProfile: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor_home)

        // ===== TOP BAR =====
        btnNotification = findViewById(R.id.btnNotification)
        btnNotificationLabel = findViewById(R.id.btnNotificationLabel)
        btnNotification.setOnClickListener {
            startActivity(Intent(this, DonorNotificationsActivity::class.java))
        }
        btnNotificationLabel.setOnClickListener {
            startActivity(Intent(this, DonorNotificationsActivity::class.java))
        }

        // ===== MAIN BUTTONS =====
        btnAvailableRequests = findViewById(R.id.btnAvailableRequests)
        btnAvailableRequests.setOnClickListener {
            startActivity(Intent(this, DonorAvailableRequestsActivity::class.java))
        }

        btnFindCenters = findViewById(R.id.btnFindCenters)
        btnFindCenters.setOnClickListener {
            startActivity(Intent(this, DonorFindCentersActivity::class.java))
        }

        btnFindHospitals = findViewById(R.id.btnFindHospitals)
        btnFindHospitals.setOnClickListener {
            startActivity(Intent(this, DonorFindHospitalsActivity::class.java))
        }

        // ===== BOTTOM NAVIGATION =====
        btnHome = findViewById(R.id.btnHome)
        btnHome.setOnClickListener {
            // Already on Home, optionally show a toast
        }

        btnFindRequests = findViewById(R.id.btnFindRequests)
        btnFindRequests.setOnClickListener {
            startActivity(Intent(this, DonorAvailableRequestsActivity::class.java))
        }

        btnDonations = findViewById(R.id.btnDonations)
        btnDonations.setOnClickListener {
            startActivity(Intent(this, DonorMyDonationsActivity::class.java))
        }

        btnProfile = findViewById(R.id.btnProfile)
        btnProfile.setOnClickListener {
            startActivity(Intent(this, DonorProfileActivity::class.java))
        }
    }
}
