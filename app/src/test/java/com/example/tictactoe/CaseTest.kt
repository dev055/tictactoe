package com.example.tictactoe

import com.example.tictactoe.models.Case
import com.example.tictactoe.models.Type
import org.junit.Assert
import org.junit.Test

class CaseTest {

    @Test
    fun testCaseIfNotNull() {
        Assert.assertEquals(true,Case() != null)
    }

    @Test
    fun testCaseHasAType() {
        val case = Case()
        case.type = Type.TYPE_O
        Assert.assertEquals(true, case.type != null)
    }
}