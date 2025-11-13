package com.example.androidprojectbloodbank

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class DonorNotificationsActivity : AppCompatActivity() {

    private lateinit var lvNotifications: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor_notifications)

        lvNotifications = findViewById(R.id.lvNotifications)

        val notifications = arrayOf(
            "New request near your area.",
            "Blood donation camp on 20 Nov.",
            "Your last donation was approved."
        )

        lvNotifications.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            notifications
        )
    }
}
