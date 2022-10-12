package com.example.makeup

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    //This variable will be global for all func that we will create
    @get:Rule var activityScenarioRule = activityScenarioRule<MainActivity>()


    // 1: check(test) if our main activity layout is displayed or is visible
    // to the user

    @Test
    fun checkActivityVisibility(){
        onView(withId(R.id.Main_activity))
            .check(matches(isDisplayed()))
    }

    // Checking if card is visible in main activity

    @Test
    fun checkCardVisibility(){
        onView(withId(R.id.card))
            .check(matches(isDisplayed()))
    }


    //testing click on image(Main Activity) and navigate to the next activity
    //and check if the second activity is displayed
    @Test
    fun navigateToSecondAct() {
        onView(withId(R.id.Image))
            .perform(click())

        //with click everything is alright
        //now check if the second activity is loaded and visible to user


        onView(withId(R.id.card))
            .check(matches(isDisplayed()))

    }
}