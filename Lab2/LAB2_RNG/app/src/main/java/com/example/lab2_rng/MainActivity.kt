package com.example.lab2_rng
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var minEditText: EditText
    private lateinit var maxEditText: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        minEditText = findViewById(R.id.minEditText)
        maxEditText = findViewById(R.id.maxEditText)
        val generateButton: Button = findViewById(R.id.generateButton)
        resultTextView = findViewById(R.id.resultTextView)

        generateButton.setOnClickListener {
            generateRandomNumber()
        }
    }

    private fun generateRandomNumber() {
        val min = minEditText.text.toString().toIntOrNull() ?: 1
        val max = maxEditText.text.toString().toIntOrNull() ?: 100

        if (min > max) {
            resultTextView.text = "Invalid range"
        } else {
            val randomNumber = Random.nextInt(min, max + 1)
            resultTextView.text = randomNumber.toString()
        }
    }
}
