package com.khavanski.caffeapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MakeOrderActivity : AppCompatActivity() {

    private lateinit var textViewGreetings: TextView
    private lateinit var textViewAdditives: TextView
    private lateinit var textViewDrink: TextView
    private lateinit var tetViewDrinkType: RadioGroup
    private lateinit var radioButtonTea: RadioButton
    private lateinit var radioButtonCoffee: RadioButton
    private lateinit var checkBoxSugar: CheckBox
    private lateinit var checkBoxMilk: CheckBox
    private lateinit var checkBoxLemon: CheckBox
    private lateinit var spinnerTea: Spinner
    private lateinit var spinnerCoffee: Spinner
    private lateinit var buttonMakeOrder: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_order)
        initViews()


        var username = intent.getStringExtra(EXTRA_USER_NAME)
    }

    companion object {

        const val EXTRA_USER_NAME = "username"
        fun newIntent(context: Context, username: String): Intent {
            val intent = Intent(context, MakeOrderActivity::class.java)
            intent.putExtra(EXTRA_USER_NAME, username)
            return intent
        }
    }

    private fun initViews() {
        textViewGreetings = findViewById(R.id.textViewGreetings)
        textViewDrink = findViewById(R.id.textViewDrink)
        tetViewDrinkType = findViewById(R.id.tetViewDrinkType)
        textViewAdditives = findViewById(R.id.textViewAdditives)
        radioButtonTea = findViewById(R.id.radioButtonTea)
        radioButtonCoffee = findViewById(R.id.radioButtonCoffee)
        checkBoxSugar = findViewById(R.id.checkBoxSugar)
        checkBoxMilk = findViewById(R.id.checkBoxMilk)
        checkBoxLemon = findViewById(R.id.checkBoxLime)
        spinnerTea = findViewById(R.id.spinnerTea)
        spinnerCoffee = findViewById(R.id.spinnerCoffee)
        buttonMakeOrder = findViewById(R.id.buttonMakeOrder)
    }
}