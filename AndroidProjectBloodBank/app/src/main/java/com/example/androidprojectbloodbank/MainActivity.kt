package com.example.androidprojectbloodbank

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 👇 Change this line to the layout file you actually have
        setContentView(R.layout.activity_splash)
    }
}
