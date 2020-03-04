package com.example.tictactoe

import com.example.tictactoe.models.Player
import org.junit.Assert
import org.junit.Test

class PlayerTest {

    @Test
    fun testIfPlayerIsNotNull() {
        Assert.assertEquals(true, Player() != null)
    }
}