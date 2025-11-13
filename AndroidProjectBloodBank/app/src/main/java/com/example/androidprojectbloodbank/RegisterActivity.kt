package com.example.androidprojectbloodbank

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val emailEditText = findViewById<EditText>(R.id.email)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val userTypeGroup = findViewById<RadioGroup>(R.id.userTypeGroup)
        val registerBtn = findViewById<Button>(R.id.registerBtn)
        val loginRedirect = findViewById<TextView>(R.id.loginRedirect)

        // Redirect to login if already have account
        loginRedirect.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        // Handle registration
        registerBtn.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val selectedUserTypeId = userTypeGroup.checkedRadioButtonId

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (selectedUserTypeId == -1) {
                Toast.makeText(this, "Please select Donor or Receiver", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedUserType = findViewById<RadioButton>(selectedUserTypeId).text.toString().trim()

            // Navigate to home based on type
            when (selectedUserType.lowercase()) {
                "receiver" -> startActivity(Intent(this, ReceiverHomeActivity::class.java))
                "donor" -> startActivity(Intent(this, DonorHomeActivity::class.java))
                else -> Toast.makeText(this, "Unknown user type", Toast.LENGTH_SHORT).show()
            }

            // Optionally finish this activity so user cannot go back
            finish()
        }
    }
}
