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
        manageIndice.number = 3
        Assert.assertEquals(true,manageIndice.number != null)
    }

    @Test
    fun testIfEndIsNotNull() {
        val manageIndice = ManageIndice()
        manageIndice.end = 2
        Assert.assertEquals(true,manageIndice.end != null)
    }
}