package com.example.tictactoe

import com.example.tictactoe.models.Case
import org.junit.Assert
import org.junit.Test

class CaseTest {

    @Test
    fun testCaseIfNotNull() {
        Assert.assertEquals(true,Case() != null)
    }

    @Test
    fun testCaseHasAType() {

    }
}