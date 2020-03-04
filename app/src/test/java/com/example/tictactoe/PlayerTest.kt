package com.example.tictactoe

import com.example.tictactoe.models.Player
import org.junit.Assert
import org.junit.Test

class PlayerTest {

    @Test
    fun testIfPlayerIsNotNull() {
        Assert.assertEquals(true, Player("player one","X") != null)
    }

    @Test
    fun testIfPlayerHasAName() {
        val player = Player("player one","O")
        Assert.assertEquals(true,player.name != null)
    }

    @Test
    fun testIfPlayerHasAType() {
        val player = Player("player one","O")
        Assert.assertEquals(true,player.type != null)
    }

    @Test
    fun testIfPlayerHasCorrect() {
        val player = Player("player one","O")
        val condition = (player.type == "O").or(player.type == "X")
        Assert.assertEquals(true,condition)
    }

    @Test
    fun testIfPlayerHasNotCorrect() {
        val player = Player("player one","T")
        val condition = (player.type == "O").or(player.type == "X")
        Assert.assertEquals(false,condition)
    }
}