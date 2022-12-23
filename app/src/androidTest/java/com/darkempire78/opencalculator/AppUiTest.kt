package com.darkempire78.opencalculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppUiTest {
    @get:Rule
    var mainActivity: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testNumberFiveButton() {
        Espresso.onView(ViewMatchers.withId(R.id.fiveButton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.input))
            .check(ViewAssertions.matches(ViewMatchers.withText("5")))
    }

    @Test
    fun testPIButton() {
        // π => 3.141592653589793
        Espresso.onView(ViewMatchers.withId(R.id.piButton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.resultDisplay))
            .check(ViewAssertions.matches(ViewMatchers.withText("3.141592653589793")))
    }

    @Test
    fun testSquareRootButton() {
        // √16 = 4
        Espresso.onView(ViewMatchers.withId(R.id.squareButton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.oneButton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.sixButton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.resultDisplay))
            .check(ViewAssertions.matches(ViewMatchers.withText("4")))
    }

    @Test
    fun testClearButton() {
        // input and result display should be cleared..
        Espresso.onView(ViewMatchers.withId(R.id.squareButton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.oneButton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.sixButton)).perform(ViewActions.click())
        // √16 = 4 , AC => CLEAR ALL

        Espresso.onView(ViewMatchers.withId(R.id.clearButton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.input))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
        Espresso.onView(ViewMatchers.withId(R.id.resultDisplay))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    @Test
    fun testBackspaceButton() {
        Espresso.onView(ViewMatchers.withId(R.id.oneButton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.sixButton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.backspaceButton)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.input))
            .check(ViewAssertions.matches(ViewMatchers.withText("1")))
    }
}
