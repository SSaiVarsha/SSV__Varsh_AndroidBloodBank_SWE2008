package com.example.androidprojectbloodbank

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class NotificationsActivity : AppCompatActivity() {

    private lateinit var lvNotifications: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        lvNotifications = findViewById(R.id.lvNotifications)

        // Sample notifications
        val notifications = listOf(
            "Blood donation request from John Doe",
            "Your donation request has been approved",
            "New nearby blood drive available",
            "Reminder: Upcoming blood donation camp",
            "Your profile has been updated successfully"
        )

        // Set adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, notifications)
        lvNotifications.adapter = adapter
    }
}
