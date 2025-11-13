package com.example.androidprojectbloodbank

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailEditText = findViewById<EditText>(R.id.email)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val userTypeGroup = findViewById<RadioGroup>(R.id.userTypeGroup)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val createAccount = findViewById<Button>(R.id.createAccount)

        // Navigate to RegisterActivity
        createAccount.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // Handle login
        loginBtn.setOnClickListener {
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

            when (selectedUserType.lowercase()) {
                "receiver" -> startActivity(Intent(this, ReceiverHomeActivity::class.java))
                "donor" -> startActivity(Intent(this, DonorHomeActivity::class.java))
                else -> Toast.makeText(this, "Unknown user type", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
