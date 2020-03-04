package com.example.tictactoe

import com.example.tictactoe.models.Game
import com.example.tictactoe.models.Player
import com.example.tictactoe.models.Type
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

        game.mBoard[0] = Player("player one",Type.TYPE_X)
        game.mBoard[1] = Player("player two",Type.TYPE_O)
        game.mBoard[2] = Player("player one",Type.TYPE_X)
        game.mBoard[3] = Player("player one",Type.TYPE_X)
        game.mBoard[4] = Player("player two",Type.TYPE_X)
        game.mBoard[5] = Player("player one",Type.TYPE_X)
        game.mBoard[6] = Player("player one",Type.TYPE_X)
        game.mBoard[7] = Player("player two",Type.TYPE_O)
        game.mBoard[8] = Player("player one",Type.TYPE_O)
    }

    @Test
    fun testIfGameExists() {
        Assert.assertEquals(true, game != null)
    }

    @Test
    fun testIfGameHasABoard() {
        Assert.assertEquals(true,game.mBoard != null)
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
        Assert.assertEquals(false,game.mBoard.isEmpty())
    }

    @Test
    fun testIfGameContainsAPlayerOne() {
        game.mPlayerOne = Player("player one",Type.TYPE_X)
        Assert.assertEquals(true,game.mPlayerOne != null)
    }

    @Test
    fun testIfGameContainsAPlayerTwo() {
        game.mPlayerTwo = Player("player two",Type.TYPE_X)
        Assert.assertEquals(true,game.mPlayerTwo != null)
    }

    @Test
    fun testIfGameContainsPlayers() {
        game.mPlayerOne = Player("player one",Type.TYPE_X)
        game.mPlayerTwo = Player("player two",Type.TYPE_X)
        val condition = (game.mPlayerOne != null && game.mPlayerTwo != null)
        Assert.assertEquals(true,condition)
    }

    @Test
    fun testIfGameIsFinished() {
        Assert.assertEquals(true,game.mBoard.size == 9)
    }

    @Test
    fun testRetrieveOnlyValuesX() {
        val valuesX = game.mBoard.filterValues { it.type == Type.TYPE_X }
        Assert.assertEquals(true,valuesX.values.toList()[0].type == Type.TYPE_X)
    }

    @Test
    fun testRetrieveOnlyValuesO() {
        val valuesX = game.mBoard.filterValues { it.type == Type.TYPE_O }
        Assert.assertEquals(true,valuesX.values.toList()[0].type == Type.TYPE_O)
    }

    @Test
    fun testRetrieveIndicesForX() {
        val indices = game.mBoard.filterValues { player -> player.type == Type.TYPE_X }.toList()
        Assert.assertEquals(true,indices.size == 6 )
    }

    @Test
    fun testRetrieveIndicesForO() {
        val indices = game.mBoard.filterValues { player -> player.type == Type.TYPE_O }.toList()
        Assert.assertEquals(true,indices.size == 3 )
    }
}