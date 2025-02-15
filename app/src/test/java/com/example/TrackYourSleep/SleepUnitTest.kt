
package com.example.TrackYourSleep

import org.junit.Assert.assertNotEquals
import org.junit.Test

/**
 * Unit tests for Sleep.
 */
class SleepUnitTest {
    @Test
    fun testEquals() {
        val sleep1 = Sleep()
        sleep1.rating = 1
        val sleep2 = Sleep()
        sleep2.rating = 2
        assertNotEquals(sleep1, sleep2)
    }
}

/* vim:set shiftwidth=4 softtabstop=4 expandtab: */
