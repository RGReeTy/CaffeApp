package com.khavanski.caffeapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MakeOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_order)
    }

    companion object {
        fun newIntent(context: Context, username: String): Intent {
            val intent = Intent(context, MakeOrderActivity::class.java)
            intent.putExtra("username", username)
            return intent
        }
    }
}