package com.example.tictactoe

import com.example.tictactoe.models.Player
import org.junit.Assert
import org.junit.Test

class PlayerTest {

    @Test
    fun testIfPlayerIsNotNull() {
        Assert.assertEquals(true, Player("player one") != null)
    }

    @Test
    fun testIfPlayerHasAName() {
        val player = Player("player one")
        Assert.assertEquals(true,player.name != null)
    }
}