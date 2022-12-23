package com.darkempire78.opencalculator

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MockingTest {
    @Mock
    lateinit var historyItem1: History

    @Mock
    lateinit var historyItem2: History

    @Mock
    lateinit var historyItem3: History

    @Mock
    lateinit var historyItem4: History

    @Mock
    lateinit var historyItem5: History

    @Before()
    fun initMocks() {
        Mockito.`when`(historyItem1.calculation).thenReturn("5+3+2")
        Mockito.`when`(historyItem2.calculation).thenReturn("15x2")
        Mockito.`when`(historyItem3.calculation).thenReturn("sin(30)")
        Mockito.`when`(historyItem4.calculation).thenReturn("50/2")
        Mockito.`when`(historyItem5.calculation).thenReturn("5!")
    }

    @Test
    fun testExtractNumbers() {
        val result: Array<String> =
            NumberFormatter.extractNumbers(historyItem1.calculation).toTypedArray()
        assertArrayEquals(arrayOf("5", "3", "2"), result)
    }

    @Test
    fun testMultiplication() {
        val result = Calculator().evaluate(Expression().getCleanExpression(historyItem2.calculation), false)
        assertEquals(15.0, result, 0.001)
    }

    @Test
    fun testTrigonometryFunctions() {
        val result = Calculator().evaluate(Expression().getCleanExpression(historyItem3.calculation), true)
        assertEquals(0.5, result, 0.001)
    }

    @Test
    fun testDivision() {
        val result = Calculator().evaluate(Expression().getCleanExpression(historyItem4.calculation), false)
        assertEquals(25.0, result, 0.001)
    }

    @Test
    fun testExpressionExtraction() {
        val result = Expression().getCleanExpression(historyItem5.calculation)
        assertEquals("factorial(5)", result)
    }
}
