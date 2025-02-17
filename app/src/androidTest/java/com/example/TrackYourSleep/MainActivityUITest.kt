package com.example.TrackYourSleep

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.Direction
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * UI tests for MainActivity.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityUITest : UITestBase() {
    @JvmField
    @Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testCreate() {
        // Given no sleeps:
        resetDatabase()

        // When creating one:
        val startStop = findObjectByRes("start_stop")
        startStop.click()
        Thread.sleep(1)
        startStop.click()

        // Then make sure we have one sleep:
        device.waitForIdle()
        var sleepCount: Int
        runBlocking {
            sleepCount = DataModel.database.sleepDao().getAll().count()
        }
        assertEquals(sleepCount, 1)
    }

    @Test
    fun testRead() {
        // Given no sleeps and creating one:
        resetDatabase()
        createSleep()

        // When waiting for 'SELECT' to be executed:
        device.waitForIdle()

        // Then make sure the sleep count widget reads the correct value:
        assertResText("fragment_stats_sleeps", "1")
    }

    @Test
    fun testDelete() {
        // Given a sleep:
        resetDatabase()
        createSleep()

        // When deleting one:
        val sleepSwipeable = findObjectByRes("sleep_swipeable")
        sleepSwipeable.swipe(Direction.RIGHT, 1F)

        // Then make sure we have no sleeps:
        assertResText("fragment_stats_sleeps", "0")
    }
}

/* vim:set shiftwidth=4 softtabstop=4 expandtab: */
