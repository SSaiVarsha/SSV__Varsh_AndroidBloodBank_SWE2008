package com.example.androidprojectbloodbank

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DonorProfileActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvPhone: TextView
    private lateinit var tvBloodGroup: TextView
    private lateinit var tvLocation: TextView
    private lateinit var tvDonations: TextView
    private lateinit var btnEditProfile: Button
    private lateinit var btnLogOut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor_profile)

        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        tvPhone = findViewById(R.id.tvPhone)
        tvBloodGroup = findViewById(R.id.tvUserBloodGroup)
        tvLocation = findViewById(R.id.tvUserLocation)
        tvDonations = findViewById(R.id.tvUserDonations)
        btnEditProfile = findViewById(R.id.btnEditProfile)
        btnLogOut = findViewById(R.id.btnLogOut)

        // Open EditProfileActivity
        btnEditProfile.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            intent.putExtra("name", tvName.text.toString())
            intent.putExtra("email", tvEmail.text.toString())
            intent.putExtra("phone", tvPhone.text.toString())
            intent.putExtra("bloodGroup", tvBloodGroup.text.toString())
            intent.putExtra("location", tvLocation.text.toString())
            startActivityForResult(intent, 101)
        }

        // Sign Out
        btnLogOut.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }

    // Update profile after editing
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101 && resultCode == Activity.RESULT_OK) {
            tvName.text = data?.getStringExtra("name")
            tvEmail.text = data?.getStringExtra("email")
            tvPhone.text = data?.getStringExtra("phone")
            tvBloodGroup.text = data?.getStringExtra("bloodGroup")
            tvLocation.text = data?.getStringExtra("location")
        }
    }
}
