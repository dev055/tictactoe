package com.example.tictactoe

import com.example.tictactoe.models.Game
import com.example.tictactoe.models.Player
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GameTest {
    private lateinit var game: Game

    @Before
    fun instantiateGame() {
        game = Game()
        game.mNumberRows = 3
        game.mNumberColumns = 3
    }

    @Test
    fun testIfGameExists() {
        Assert.assertEquals(true, game != null)
    }

    @Test
    fun testIfGameHasABoard() {
        Assert.assertEquals(true,game.board != null)
    }

    @Test
    fun testIfGameHasNumberOfRows() {
        Assert.assertEquals(true,game.mNumberRows != null)
    }

    @Test
    fun testIfGameHasNumberOfColumns() {
        Assert.assertEquals(true,game.mNumberColumns != null)
    }

    @Test
    fun testIfBoardContainsValues() {
        game.board[0] = "X"
        game.board[1] = "O"
        game.board[2] = "X"
        Assert.assertEquals(false,game.board.isEmpty())
    }

    @Test
    fun testIfGameContainsAPlayerOne() {
        game.playerOne = Player("player one")
        Assert.assertEquals(true,game.playerOne != null)
    }

    @Test
    fun testIfGameContainsAPlayerTwo() {
        game.playerTwo = Player("player two")
        Assert.assertEquals(true,game.playerTwo != null)
    }

    @Test
    fun testIfGameContainsPlayers() {
        game.playerOne = Player("player one")
        game.playerTwo = Player("player two")
        val condition = (game.playerOne != null && game.playerTwo != null)
        Assert.assertEquals(true,condition)
    }
}