package com.hcl.login.assignement.view

import androidx.test.espresso.Espresso.onView

import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.hcl.login.assignement.R
import kotlinx.coroutines.delay
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeoutException
import kotlin.concurrent.thread


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    @JvmField
    var acitivityTestRule=ActivityTestRule(MainActivity::class.java)
    lateinit var myActivity: MainActivity

    @Before
    fun setup(){
        myActivity=acitivityTestRule.activity
    }
    @Test
    fun loginTest(){
        onView(withId(R.id.et_password)).perform(typeText("1234"))
        onView(withId(R.id.et_username)).perform(typeText("kote"))
        onView(withId(R.id.bt_login)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.textTest)).check(matches(withText("ok")))

    }
    @Test
    fun validUseraName(){
        onView(withId(R.id.et_password)).perform(typeText("1234"))
        onView(withId(R.id.bt_login)).perform(click())
        onView(withId(R.id.et_username)).check(matches(hasErrorText("username required")))
    }
    @Test
    fun validPassowrd(){
        onView(withId(R.id.et_username)).perform(typeText("kote"))
        onView(withId(R.id.bt_login)).perform(click())
        onView(withId(R.id.et_password)).check(matches(hasErrorText("password required")))

    }

    @After
    fun tearDown(){
        true
    }






























    /*@Rule @JvmField
    var mactivityTestRule= ActivityTestRule(MainActivity::class.java)

    lateinit var mainActivity : MainActivity

    lateinit var toastMatcher: ToastMatcher
    @Before
    fun setUp() {
        mainActivity=mactivityTestRule.activity
        toastMatcher= ToastMatcher()
    }
    @After
    fun tearDown() {
        true
    }
    @Test
    fun emptyUsernameCheckTest() {
        onView(withId(R.id.et_password)).perform(typeText("kote"))
        onView(withId(R.id.bt_login)).perform(click())
        onView(withId(R.id.et_username)).check(matches(hasErrorText("username required")))

    }
    @Test
    fun emptyPasswordCheckTest() {
        onView(withId(R.id.et_username)).perform(typeText("1234"))
        onView(withId(R.id.bt_login)).perform(click())
        onView(withId(R.id.et_password)).check(matches(hasErrorText("password required")))

    }

    @Test
    fun loginCheckTest() {
        onView(withId(R.id.et_username)).perform(typeText("kote"))
        onView(withId(R.id.et_password)).perform(typeText("1234"))
        onView(withId(R.id.bt_login)).perform(click())
        onView(withId(R.id.recyclerview))
            .waitUntilVisible(5000)
            .check(matches(isDisplayed()));
    }
    @Test
    fun toastMessageTest(){
        onView(withId(R.id.et_username)).perform(typeText("kote9"))
        onView(withId(R.id.et_password)).perform(typeText("1234k"))
        onView(withId(R.id.bt_login)).perform(click())
        onView(withText("Problem: Please check credentials"))
            .inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }
    fun ViewInteraction.waitUntilVisible(timeout: Long): ViewInteraction {
        val startTime = System.currentTimeMillis()
        val endTime = startTime + timeout

        do {
            try {
                check(matches(isDisplayed()))
                return this
            } catch (e: NoMatchingViewException) {
                Thread.sleep(50)
            }
        } while (System.currentTimeMillis() < endTime)

        throw TimeoutException()
    }*/

}