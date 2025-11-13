package com.example.androidprojectbloodbank

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var etAddress: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        // Initialize views
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        etAddress = findViewById(R.id.etAddress)
        btnSave = findViewById(R.id.btnSaveProfile)

        // Load saved profile data
        loadProfile()

        // Save button click
        btnSave.setOnClickListener {
            saveProfile()
        }
    }

    private fun loadProfile() {
        val prefs = getSharedPreferences("UserProfile", Context.MODE_PRIVATE)
        etName.setText(prefs.getString("name", ""))
        etEmail.setText(prefs.getString("email", ""))
        etPhone.setText(prefs.getString("phone", ""))
        etAddress.setText(prefs.getString("address", ""))
    }

    private fun saveProfile() {
        val name = etName.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val phone = etPhone.text.toString().trim()
        val address = etAddress.text.toString().trim()

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val prefs = getSharedPreferences("UserProfile", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString("name", name)
        editor.putString("email", email)
        editor.putString("phone", phone)
        editor.putString("address", address)
        editor.apply()

        Toast.makeText(this, "Profile saved successfully", Toast.LENGTH_SHORT).show()

        // Optional: go back to Profile page
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
        finish()
    }
}
