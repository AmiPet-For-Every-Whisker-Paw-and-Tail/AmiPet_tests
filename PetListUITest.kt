// Testa a lista de pets
// frontend/kotlin/src/androidTest/java/com/amipet/PetListUITest.kt

package com.amipet

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.amipet.ui.home.PetListActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

@RunWith(AndroidJUnit4::class)
class PetListUITest {

    @get:Rule
    val activityRule = ActivityTestRule(PetListActivity::class.java)

    @Test
    fun testPetListLoads() {
        onView(withId(R.id.petRecyclerView)).check(matches(isDisplayed()))
    }
}
