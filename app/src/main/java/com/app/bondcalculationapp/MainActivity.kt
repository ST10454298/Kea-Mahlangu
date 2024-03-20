package com.app.bondcalculationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etFirstName = findViewById<EditText>(R.id.etFirstName).text
        val etSurname = findViewById<EditText>(R.id.etSurname).text
        val etAge = findViewById<EditText>(R.id.etAge).text
        val etSalary = findViewById<EditText>(R.id.etSalary).text

        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)

        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val coupon = etSalary.toString().toDouble() / (1 + (11.75/100)) .pow(etAge.toString().toInt())

            val price = 2000000
            val duration = 20

            val housevalue = price / (1 + (11.75/100)) .pow(duration)

            val result = coupon + housevalue

            tvResult.text = "Hi ${etFirstName.toString()} ${etSurname.toString()}, your bond value is R ${result}"

        }
        btnClear.setOnClickListener {
            etFirstName.clear()
            etSurname.clear()
            etAge.clear()
            etSalary.clear()
        }
    }
}