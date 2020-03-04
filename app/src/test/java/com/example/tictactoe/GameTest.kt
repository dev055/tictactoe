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

        game.board[0] = Player("player one","X")
        game.board[1] = Player("player two","O")
        game.board[2] = Player("player one","X")
        game.board[3] = Player("player one","X")
        game.board[4] = Player("player two","X")
        game.board[5] = Player("player one","X")
        game.board[6] = Player("player one","X")
        game.board[7] = Player("player two","O")
        game.board[8] = Player("player one","O")
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
        Assert.assertEquals(false,game.board.isEmpty())
    }

    @Test
    fun testIfGameContainsAPlayerOne() {
        game.playerOne = Player("player one","X")
        Assert.assertEquals(true,game.playerOne != null)
    }

    @Test
    fun testIfGameContainsAPlayerTwo() {
        game.playerTwo = Player("player two","X")
        Assert.assertEquals(true,game.playerTwo != null)
    }

    @Test
    fun testIfGameContainsPlayers() {
        game.playerOne = Player("player one","X")
        game.playerTwo = Player("player two","X")
        val condition = (game.playerOne != null && game.playerTwo != null)
        Assert.assertEquals(true,condition)
    }

    @Test
    fun testIfGameIsFinished() {
        Assert.assertEquals(true,game.board.size == 9)
    }
}