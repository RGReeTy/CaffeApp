package com.khavanski.caffeapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderDetailActivity : AppCompatActivity() {

    private lateinit var usernameTextView: TextView
    private lateinit var textViewDrink: TextView
    private lateinit var tetViewDrinkType: TextView
    private lateinit var textViewAdditive: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)
        initViews()

        usernameTextView.text = intent.getStringExtra(EXTRA_USER_NAME)
        textViewDrink.text = intent.getStringExtra(EXTRA_DRINK)
        tetViewDrinkType.text = intent.getStringExtra(EXTRA_DRINK_TYPE)
        val stringExtra: java.util.ArrayList<String>? = intent.getStringArrayListExtra(EXTRA_ADDITIVES)
        textViewAdditive.text = stringExtra.toString()
    }

    private fun initViews() {
        usernameTextView = findViewById(R.id.textViewName)
        textViewDrink = findViewById(R.id.textViewDrink)
        tetViewDrinkType = findViewById(R.id.tetViewDrinkType)
        textViewAdditive = findViewById(R.id.textViewAdditive)
    }

    companion object {
        private const val EXTRA_USER_NAME = "username"
        private const val EXTRA_DRINK = "drink"
        private const val EXTRA_DRINK_TYPE = "drinkType"
        private const val EXTRA_ADDITIVES = "additives"

        fun newIntent(
            context: Context,
            username: String,
            drink: String,
            drinkType: String,
            additives: ArrayList<String>
        ): Intent {
            val intent = Intent(context, OrderDetailActivity::class.java)
            intent.putExtra(EXTRA_USER_NAME, username)
            intent.putExtra(EXTRA_DRINK, drink)
            intent.putExtra(EXTRA_DRINK_TYPE, drinkType)
            intent.putExtra(EXTRA_ADDITIVES, additives)
            return intent
        }
    }
}