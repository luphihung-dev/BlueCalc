package com.luphihung.bluecalc

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.assertEquals

@RunWith(AndroidJUnit4::class)
class BlueCalcInstrumentedTest {
    @Test
    fun appContext_usesExpectedPackageName() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        assertEquals("com.luphihung.bluecalc", appContext.packageName)
    }
}
