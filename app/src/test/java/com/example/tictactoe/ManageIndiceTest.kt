package com.example.tictactoe

import com.example.tictactoe.models.ManageIndice
import org.junit.Assert
import org.junit.Test

class ManageIndiceTest {

    @Test
    fun testIfModelExists() {
        Assert.assertEquals(true, ManageIndice() != null)
    }

    @Test
    fun testIfNumberIsNotNull() {
        val manageIndice = ManageIndice()
        manageIndice.mNumber = 3
        Assert.assertEquals(true,manageIndice.mNumber != null)
    }

    @Test
    fun testIfEndIsNotNull() {
        val manageIndice = ManageIndice()
        manageIndice.mEnd = 2
        Assert.assertEquals(true,manageIndice.mEnd != null)
    }

    @Test
    fun testIfStringBuilderIsNotNull() {
        val manageIndice = ManageIndice()
        Assert.assertEquals(true,manageIndice.mResult!= null)
    }
}