package com.example.mycalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
  private var tvInput: TextView? = null
  var lastNumeric: Boolean = false
  var lastDot: Boolean = false

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    tvInput = findViewById(R.id.tvInput)
  }

  fun onDigit(view: View) {
    tvInput?.append((view as Button).text)
    lastNumeric = true
  }

  fun onClear(view: View) {
    tvInput?.text = ""
    lastDot = false
  }

  fun onDecimalPoint(view: View) {
    if (lastNumeric && !lastDot) {
      tvInput?.append(".")
      lastNumeric = false
      lastDot = true
    }
  }

  fun onOperator(view: View) {
    if (lastNumeric && !isOperatorAdded(tvInput?.text.toString())) {
      tvInput?.append((view as Button).text)
      lastNumeric = false
      lastDot = false
    }
  }

  private fun isOperatorAdded(value: String): Boolean {
    return if (value.startsWith("-")) {
      false
    } else {
      value.contains("/") ||
              value.contains("*") ||
              value.contains("-") ||
              value.contains("+")
    }
  }
}