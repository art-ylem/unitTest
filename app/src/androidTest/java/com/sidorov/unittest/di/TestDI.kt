package com.sidorov.unittest.di

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.sidorov.unittest.Note
import com.sidorov.unittest.R
import com.sidorov.unittest.ResourcesManagerTestImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class TestDI {

    @Inject
    lateinit var note: Note

    @Inject
    lateinit var recources: ResourcesManagerTestImpl

    @Before
    fun setUp() {
        val testComponent: TestAppComponent =
            DaggerTestAppComponent.builder()
                .context(InstrumentationRegistry.getInstrumentation().targetContext.applicationContext)
                .build()
        testComponent.inject(this)
    }

    @Test
    fun testInjection() {
        Assert.assertEquals(note.name, "Name")
        Assert.assertEquals(recources.getString(R.string.app_name), "UnitTest")
    }
}
