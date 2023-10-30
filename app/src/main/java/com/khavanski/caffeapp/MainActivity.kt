package com.khavanski.caffeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonSignIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        buttonSignIn.setOnClickListener {
            val username = editTextName.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if (username.isBlank() || password.isBlank()) {
                Toast.makeText(this, R.string.errorFieldsEmpty, Toast.LENGTH_SHORT).show()
            } else {
                launchNextScreen(username)
            }
        }

    }

    private fun launchNextScreen(username: String) {
        val intent = MakeOrderActivity.newIntent(this, username)
        startActivity(intent)
    }

    private fun initViews() {
        editTextName = findViewById(R.id.editTextName)
        editTextPassword = findViewById(R.id.editTextPass)
        buttonSignIn = findViewById(R.id.signInButton)
    }
}