package com.khavanski.caffeapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
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
    private lateinit var radioGroupDrinkTypes: RadioGroup
    private lateinit var radioButtonTea: RadioButton
    private lateinit var radioButtonCoffee: RadioButton
    private lateinit var checkBoxSugar: CheckBox
    private lateinit var checkBoxMilk: CheckBox
    private lateinit var checkBoxLemon: CheckBox
    private lateinit var spinnerTea: Spinner
    private lateinit var spinnerCoffee: Spinner
    private lateinit var buttonMakeOrder: Button
    private lateinit var drink: String
    private lateinit var username: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_order)

        initViews()
        setupGreetings()

        radioGroupDrinkTypes.setOnCheckedChangeListener { _, id -> // checkedId is the RadioButton selected
            if (id == radioButtonTea.id) {
                onUserChoseTea()
            } else if (id == radioButtonCoffee.id) {
                onUserChoseCoffee()
            }
        }
        radioButtonTea.isChecked = true

        buttonMakeOrder.setOnClickListener {
            val drinkType = onUserMakeOrder()
            val additives = onUserChoseAdditives()
            launchNextScreen(username, drink, drinkType, additives)
        }

    }

    private fun launchNextScreen(
        username: String,
        drink: String,
        drinkType: String,
        additives: ArrayList<String>
    ) {
        val intent = OrderDetailActivity.newIntent(this, username, drink, drinkType, additives)
        startActivity(intent)
    }

    private fun onUserChoseAdditives(): ArrayList<String> {
        val additives = ArrayList<String>()
        if (checkBoxSugar.isChecked) {
            additives.add(checkBoxSugar.text.toString())
        }
        if (checkBoxMilk.isChecked) {
            additives.add(checkBoxMilk.text.toString())
        }
        if (radioButtonTea.isChecked && checkBoxLemon.isChecked) {
            additives.add(checkBoxLemon.text.toString())
        }
        return additives
    }

    private fun onUserMakeOrder(): String {
        var drinkType: String = ""
        if (radioButtonTea.isChecked) {
            drinkType = spinnerTea.selectedItem.toString()
        } else if (radioButtonCoffee.isChecked) {
            drinkType = spinnerCoffee.selectedItem.toString()
        }
        return drinkType
    }

    private fun onUserChoseTea() {
        drink = getString(R.string.tea)
        val additivesLabel = getString(R.string.additives, drink)
        textViewAdditives.text = additivesLabel
        checkBoxLemon.visibility = View.VISIBLE
        spinnerTea.visibility = View.VISIBLE
        spinnerCoffee.visibility = View.INVISIBLE
    }


    private fun onUserChoseCoffee() {
        drink = getString(R.string.coffee)
        val additivesLabel = getString(R.string.additives, drink)
        textViewAdditives.text = additivesLabel
        checkBoxLemon.visibility = View.INVISIBLE
        spinnerTea.visibility = View.INVISIBLE
        spinnerCoffee.visibility = View.VISIBLE
    }

    private fun setupGreetings() {
        username = intent.getStringExtra(EXTRA_USER_NAME)!!
        textViewGreetings.text = getString(R.string.greetings, username)
    }


    private fun initViews() {
        textViewGreetings = findViewById(R.id.textViewGreetings)
        radioGroupDrinkTypes = findViewById(R.id.radioGroupDrinks)
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

    companion object {

        const val EXTRA_USER_NAME = "username"
        fun newIntent(context: Context, username: String): Intent {
            val intent = Intent(context, MakeOrderActivity::class.java)
            intent.putExtra(EXTRA_USER_NAME, username)
            return intent
        }
    }
}