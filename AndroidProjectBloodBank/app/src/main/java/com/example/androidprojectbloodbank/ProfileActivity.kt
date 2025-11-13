package com.example.androidprojectbloodbank

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvPhone: TextView
    private lateinit var btnEditProfile: Button
    private lateinit var btnSignOut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        tvPhone = findViewById(R.id.tvPhone)
        btnEditProfile = findViewById(R.id.btnEditProfile)
        btnSignOut = findViewById(R.id.btnSignOut)

        // Open EditProfileActivity
        btnEditProfile.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            intent.putExtra("name", tvName.text.toString())
            intent.putExtra("email", tvEmail.text.toString())
            intent.putExtra("phone", tvPhone.text.toString())
            startActivityForResult(intent, 100)
        }

        // Sign Out
        btnSignOut.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }

    // Update profile after editing
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK) {
            tvName.text = data?.getStringExtra("name")
            tvEmail.text = data?.getStringExtra("email")
            tvPhone.text = data?.getStringExtra("phone")
        }
    }
}
