package com.khavanski.caffeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_order)
        val intent = Intent(this, MakeOrderActivity::class.java)
        startActivity(intent)

    }
}