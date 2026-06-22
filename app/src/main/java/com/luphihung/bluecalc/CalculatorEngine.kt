package com.luphihung.bluecalc

import androidx.annotation.StringRes
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

enum class CalculatorOperation(
    @param:StringRes val labelRes: Int,
    val symbol: String
) {
    Add(R.string.add, "+"),
    Subtract(R.string.subtract, "-"),
    Multiply(R.string.multiply, "x"),
    Divide(R.string.divide, "÷")
}

object CalculatorEngine {
    fun calculate(firstOperand: Double, secondOperand: Double, operation: CalculatorOperation): Double {
        return when (operation) {
            CalculatorOperation.Add -> firstOperand + secondOperand
            CalculatorOperation.Subtract -> firstOperand - secondOperand
            CalculatorOperation.Multiply -> firstOperand * secondOperand
            CalculatorOperation.Divide -> {
                require(secondOperand != 0.0) { "Cannot divide by zero" }
                firstOperand / secondOperand
            }
        }
    }

    fun formatNumber(value: Double): String {
        require(value.isFinite()) { "Result must be a finite number" }

        val symbols = DecimalFormatSymbols.getInstance(Locale.getDefault())
        return DecimalFormat("0.##########", symbols).format(value)
    }
}
