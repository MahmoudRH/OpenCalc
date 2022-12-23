package com.darkempire78.opencalculator

import org.junit.Assert.*
import org.junit.Test

class AppUnitTests {

    /** issue #56 and #117*/
    @Test
    fun testNumberFormatter_MultipleNumbers() {
        // it shouldn't add zeros..
        val text: String = NumberFormatter.format(".001+00.02+5555.05")
        assertEquals(".001+0.02+5,555.05", text)
    }

    @Test
    fun testAddingTwoNumbers() {
        val result: Double = Calculator().evaluate(Expression().getCleanExpression("1+1"), false)
        assertEquals(2.0, result, 0.0)
    }

    @Test
    fun testMultiplyingTwoNumbers() {
        val result: Double = Calculator().evaluate(Expression().getCleanExpression("5*2"), false)
        assertEquals(10.0, result, 0.0)
    }

    @Test
    fun testDividingTwoNumbers() {
        val result: Double = Calculator().evaluate(Expression().getCleanExpression("40/2"), false)
        assertEquals(20.0, result, 0.0)
    }

    @Test
    fun testSubtractingTwoNumbers() {
        val result: Double = Calculator().evaluate(Expression().getCleanExpression("50-20"), false)
        assertEquals(30.0, result, 0.0)
    }

    @Test
    fun testDivideByZero() {
        try {
            val res: Double = Calculator().evaluate(Expression().getCleanExpression("50/0"), false)
            fail("exception not thrown (Divide by zero)")
        } catch (e: Exception) {
            assertTrue("exception is handled", true)
        }
    }

    @Test
    fun testIllegalArguments() {
        try {
            val res: Double = Calculator().evaluate(Expression().getCleanExpression("helloWorld"), false)
            fail("exception not thrown (IllegalArgumentException)")
        } catch (e: Exception) {
            assertTrue("exception is handled", true)
        }
    }
}
