package com.darkempire78.opencalculator

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
@RunWith(Parameterized::class)
class ParameterizedTests(private val expression: String, private val expectedResult: Double, private val delta: Double) {

    @Test
    fun testExpressions() {
        val actualResult = Calculator().evaluate(Expression().getCleanExpression(expression), true)
        assertEquals(expectedResult, actualResult, delta)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun expressions(): List<Array<Any>> {
            return listOf(
                arrayOf("sin(90)", 1.0, 0.0001),
                arrayOf("cos(60)", 0.5, 0.0001)
            )
        }
    }
}
