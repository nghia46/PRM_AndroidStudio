package com.example.lab2_caculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var txtNum1: EditText
    private lateinit var txtNum2: EditText
    private lateinit var buttonCong: Button
    private lateinit var buttonTru: Button
    private lateinit var buttonNhan: Button
    private lateinit var buttonChia: Button
    private lateinit var txtResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)
        buttonCong = findViewById(R.id.buttonCong)
        buttonTru = findViewById(R.id.buttonTru)
        buttonNhan = findViewById(R.id.buttonNhan)
        buttonChia = findViewById(R.id.buttonChia)
        txtResult = findViewById(R.id.txtResult)

        // Set click listeners for buttons
        buttonCong.setOnClickListener { calculate("+") }
        buttonTru.setOnClickListener { calculate("-") }
        buttonNhan.setOnClickListener { calculate("*") }
        buttonChia.setOnClickListener { calculate("/") }
    }

    private fun calculate(operation: String) {
        val num1Str = txtNum1.text.toString()
        val num2Str = txtNum2.text.toString()

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập số", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = num1Str.toDoubleOrNull()
        val num2 = num2Str.toDoubleOrNull()

        if (num1 == null || num2 == null) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show()
            return
        }

        val result = when (operation) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 != 0.0) num1 / num2 else {
                Toast.makeText(this, "Không thể chia cho 0", Toast.LENGTH_SHORT).show()
                return
            }
            else -> 0.0
        }

        txtResult.text = result.toString()
    }
}
