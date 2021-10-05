package com.sidorov.unittest

import org.junit.*
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

class BestPractice1() {

    private lateinit var resManager: ResourcesManagerInterface

    companion object {
        var a = 0
    }

    @Before
    fun resetVariables() {
        resManager = mock<ResourcesManagerInterface> {
            on { getString(any()) } doReturn "myMockStringRes"
        }
        a = 1
    }

    @After
    fun changeVariables() {
        a = 0
    }

    @Test
    fun `best practice 2 example test`() {
        Assert.assertEquals("myMockStringRes", resManager.getString(any()))
    }

    @Ignore
    @Test(timeout = 5000)
    fun `best practice 1 example test`() {
        while (true) a++
        Assert.assertEquals(1, a)
    }
}
