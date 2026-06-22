package com.example.project_exercise_1

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class CalculatorEngineTest {
    @Test
    fun addition_returnsSum() {
        assertEquals(9.0, CalculatorEngine.calculate(4.0, 5.0, CalculatorOperation.Add), 0.0001)
    }

    @Test
    fun subtraction_returnsDifference() {
        assertEquals(2.0, CalculatorEngine.calculate(7.0, 5.0, CalculatorOperation.Subtract), 0.0001)
    }

    @Test
    fun multiplication_returnsProduct() {
        assertEquals(30.0, CalculatorEngine.calculate(6.0, 5.0, CalculatorOperation.Multiply), 0.0001)
    }

    @Test
    fun division_returnsQuotient() {
        assertEquals(3.0, CalculatorEngine.calculate(12.0, 4.0, CalculatorOperation.Divide), 0.0001)
    }

    @Test
    fun decimalCalculation_formatsCleanly() {
        val result = CalculatorEngine.calculate(2.5, 1.25, CalculatorOperation.Add)

        assertEquals("3.75", CalculatorEngine.formatNumber(result))
    }

    @Test
    fun negativeNumberCalculation_returnsExpectedResult() {
        assertEquals(-8.0, CalculatorEngine.calculate(-4.0, 2.0, CalculatorOperation.Multiply), 0.0001)
    }

    @Test
    fun divisionByZero_throwsException() {
        assertThrows(IllegalArgumentException::class.java) {
            CalculatorEngine.calculate(10.0, 0.0, CalculatorOperation.Divide)
        }
    }

    @Test
    fun wholeNumberFormat_removesUnnecessaryDecimal() {
        assertEquals("12", CalculatorEngine.formatNumber(12.0))
    }
}
