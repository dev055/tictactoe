package com.example.tictactoe

import com.example.tictactoe.models.Game
import com.example.tictactoe.models.Player
import com.example.tictactoe.models.Type
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.lang.StringBuilder

class GameTest {
    private lateinit var game: Game
    private var indicesForRows = "0 1 2-3 4 5-6 7 8"
    private var indicesForColumns = "0 3 6-1 4 7-2 5 8"
    private var indicesForFirstDiagonally = "0 4 8"
    private var indicesForSecondDiagonally = "2 4 6"
    private var playerOneIndices = "0 2 3 4 5 6"
    private var playerTwoIndices = "1 7 8"

    @Before
    fun instantiateGame() {
        game = Game(3,3)

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

    @Test
    fun testRetrieveIndicesOfRows() {
        val indForRows = game.getIndicesForElement(3,1,3)
        Assert.assertEquals(true,indForRows == indicesForRows)
    }

    @Test
    fun testRetrieveIndicesOfColumns() {
        val indForColumns = game.getIndicesForElement(1,3,3)
        Assert.assertEquals(true,indForColumns == indicesForColumns)
    }

    @Test
    fun testRetrieveIndicesOfFirstDiagonally() {
        val indForFirstDiag = game.getIndicesForDiagonally(0,4,3)
        Assert.assertEquals(true,indForFirstDiag == indicesForFirstDiagonally)
    }

    @Test
    fun testRetrieveIndicesOfSecondDiagonally() {
        val indForSecondDiag = game.getIndicesForDiagonally(2,2,3)
        Assert.assertEquals(true,indForSecondDiag == indicesForSecondDiagonally)
    }

    @Test
    fun testIfPlayerOneWins() {
        Assert.assertEquals(true,game.areyouwin(Type.TYPE_X))
    }

    @Test
    fun testGetIndicesFunctionGenericForRows() {
        var element = 0
        var number = 3
        var addForElement = 3
        var addForIndex = 1
        var end = number.minus(1)
         var result = StringBuilder()
        for(x in 0..end) {
            var indexToSave = element
            var start = element
            for(start in 0..end) {
                result.append("$indexToSave ")
                indexToSave += addForIndex
            }
            result.deleteCharAt(result.length.minus(1))
            result.append("-")
            element += addForElement
        }
        result.deleteCharAt(result.length.minus(1))
        println("$indicesForRows")
        println("${result.toString()}")
        Assert.assertEquals(true,indicesForRows == result.toString())
    }

    @Test
    fun testGetIndicesFunctionGenericForColumns() {
        var element = 0
        var number = 3
        var addForElement = 1
        var addForIndex = 3
        var end = number.minus(1)
        var result = StringBuilder()
        for(x in 0..end) {
            var indexToSave = element
            var start = element
            for(start in 0..end) {
                result.append("$indexToSave ")
                indexToSave += addForIndex
            }
            result.deleteCharAt(result.length.minus(1))
            result.append("-")
            element += addForElement
        }
        result.deleteCharAt(result.length.minus(1))
        Assert.assertEquals(true,indicesForColumns == result.toString())
    }

    @Test
    fun testGetIndicesFunctionGenericForFirstDiagonally() {
        var element = 0
        var number = 3
        var addForIndex = 4
        var end = number.minus(1)
        var result = StringBuilder()
        var indexToSave = element
        for(x in 0..end) {
            result.append("$indexToSave ")
            indexToSave += addForIndex
        }
        result.deleteCharAt(result.length.minus(1))
        Assert.assertEquals(true,result.toString() == indicesForFirstDiagonally)
    }

    @Test
    fun testSavePositionForACase() {
        val player = Player("player one",Type.TYPE_X)
        game.mBoard[1] = player
        Assert.assertEquals(true, game.mBoard[1] == player)
    }
}