package com.example.tictactoe

import com.example.tictactoe.models.Game
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GameTest {
    private lateinit var game: Game

    @Before
    fun instantiateGame() {
        game = Game()
    }

    @Test
    fun testIfGameExists() {
        Assert.assertEquals(true, game != null)
    }

    @Test
    fun testIfGameHasABoard() {
        Assert.assertEquals(true,game.board != null)
    }
}