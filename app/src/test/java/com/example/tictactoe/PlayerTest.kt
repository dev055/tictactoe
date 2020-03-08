package com.example.tictactoe

import com.example.tictactoe.models.Player
import com.example.tictactoe.models.Type
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PlayerTest {
    lateinit var player: Player

    @Before
    fun instantiatePlayer() {
        player = Player("player one",Type.TYPE_X)
    }
    @Test
    fun testIfPlayerIsNotNull() {
        Assert.assertEquals(true, player != null)
    }

    @Test
    fun testIfPlayerHasAName() {
        val player = Player("player one",Type.TYPE_X)
        Assert.assertEquals(true,player.name != null)
    }

    @Test
    fun testIfPlayerHasAType() {
        val player = Player("player one",Type.TYPE_X)
        Assert.assertEquals(true,player.type != null)
    }

    @Test
    fun testIfPlayerHasCorrect() {
        val player = Player("player one",Type.TYPE_X)
        val condition = (player.type == Type.TYPE_X).or(player.type == Type.TYPE_O)
        Assert.assertEquals(true,condition)
    }

    @Test
    fun testIfPlayerHasNotCorrect() {
        val player = Player("player one",7)
        val condition = (player.type == Type.TYPE_X).or(player.type == Type.TYPE_O)
        Assert.assertEquals(false,condition)
    }
}