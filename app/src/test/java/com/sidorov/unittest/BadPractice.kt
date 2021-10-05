package com.sidorov.unittest

import org.junit.Assert.*
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

/**
 *  There are many asserts in one test
 */
class BadPractice1 {
    @Test
    fun `bad practice 1 example test`() {
        assertEquals(1, 1)
        assertEquals(2, 2)
    }
}

/**
 *  Shared state
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class BadPractice2 {
    private var a = 1

    @Test
    fun `abad practice 2 example test`() {
        assertEquals(1, a)
        a = 0
    }

    @Test
    fun `bad practice 2 example test(2)`() {
        assertEquals(1, a)
    }
}
