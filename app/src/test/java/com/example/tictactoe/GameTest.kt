package com.example.tictactoe

import com.example.tictactoe.models.Game
import com.example.tictactoe.models.Player
import com.example.tictactoe.models.Type
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.lang.StringBuilder
import com.example.tictactoe.utils.StringUtil.containsPossibilities

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

        game.mBoard[0] = Type.TYPE_X
        game.mBoard[1] = Type.TYPE_O
        game.mBoard[2] = Type.TYPE_X
        game.mBoard[3] = Type.TYPE_X
        game.mBoard[4] = Type.TYPE_X
        game.mBoard[5] = Type.TYPE_X
        game.mBoard[6] = Type.TYPE_X
        game.mBoard[7] = Type.TYPE_O
        game.mBoard[8] = Type.TYPE_O

        game.mCurrent = Player("player one",Type.TYPE_X)
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
        val valuesX = game.mBoard.filterValues { it == Type.TYPE_X }
        Assert.assertEquals(true,valuesX.values.toList()[0] == Type.TYPE_X)
    }

    @Test
    fun testRetrieveOnlyValuesO() {
        val valuesX = game.mBoard.filterValues { it == Type.TYPE_O }
        Assert.assertEquals(true,valuesX.values.toList()[0] == Type.TYPE_O)
    }

    @Test
    fun testRetrieveIndicesForX() {
        val indices = game.mBoard.filterValues { type -> type == Type.TYPE_X }.toList()
        Assert.assertEquals(true,indices.size == 6 )
    }

    @Test
    fun testRetrieveIndicesForO() {
        val indices = game.mBoard.filterValues { type -> type == Type.TYPE_O }.toList()
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
        game.mPlayerOne = Player("player one",Type.TYPE_X)
        game.mPlayerTwo = Player("player two",Type.TYPE_O)
        Assert.assertEquals(true,game.whoWins() != null)
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
        game.savePosition(1,Type.TYPE_X)
        Assert.assertEquals(false, game.mBoard[1] == player.type)
    }

    @Test
    fun testSaveCurrentPlayer() {
        val player = Player("player one",Type.TYPE_X)
        game.mPlayerOne = player
        game.mCurrent = player
        Assert.assertEquals(true,game.mCurrent == game.mPlayerOne)
    }

    @Test
    fun testWhoPlaysIfPreviousIsPlayerOne() {
        val player =  Player("player one",Type.TYPE_X)
        if(game.mCurrent!!.name == player.name)
            game.mCurrent =  Player("player two",Type.TYPE_O)
        else
            game.mCurrent =  Player("player one",Type.TYPE_X)
        Assert.assertEquals(true,game.mCurrent!!.name == Player("player two",Type.TYPE_O).name)
    }

    @Test
    fun testPlayerOnePlaysIfNoCurrent() {
        val player =  Player("player one",Type.TYPE_X)
        if(game.mCurrent == null)
            game.mCurrent =  Player("player one",Type.TYPE_X)
        Assert.assertEquals(true,game.mCurrent!!.name == Player("player one",Type.TYPE_X).name)
    }

    @Test
    fun testSavePositionForACaseIfIsEmpty() {
        val player = Player("player one",Type.TYPE_O)
        if(game.mBoard[2] == null) game.savePosition(0,player.type)
        Assert.assertEquals(true, game.mBoard[2] == Type.TYPE_X)
    }

    @Test
    fun testWhenWeCanApplyRules() {
        var board = HashMap<Int,Int>()
        board[0] = Type.TYPE_X
        board[1] = Type.TYPE_O
        board[2] = Type.TYPE_X
        board[3] = Type.TYPE_X
        Assert.assertEquals(false,board.size >= 5)
    }

    @Test
    fun testWhenWeCanApplyRulesV2() {
        Assert.assertEquals(true,game.mBoard.size >= 5)
    }

    @Test
    fun testWhoWinsWithPlayerOneCheckJustRows() {
        var  playerOneWins = false
        game.mPlayerOne = Player("player one",Type.TYPE_X)
        if(game.atLeast5FilledCases()) {
            var playerOneIndices = game.getIndices(game.mPlayerOne!!.type)
            var possibilities = game.getIndicesForElement(3,1,3)
            var split = possibilities.split("-")
            playerOneWins = (playerOneIndices.containsPossibilities(split[0])
                    || playerOneIndices.containsPossibilities(split[1])
                    || playerOneIndices.containsPossibilities(split[2]) )
        }
        Assert.assertEquals(true,playerOneWins)
    }

    @Test
    fun testWhoWinsWithPlayerOneCheckJustColumns() {
        var  playerOneWins = false
        game.mPlayerOne = Player("player one",Type.TYPE_X)
        if(game.atLeast5FilledCases()) {
            var playerOneIndices = game.getIndices(game.mPlayerOne!!.type)
            var possibilities = game.getIndicesForElement(1,3,3)
            var split = possibilities.split("-")
            playerOneWins = (playerOneIndices.containsPossibilities(split[0])
                    || playerOneIndices.containsPossibilities(split[1])
                    || playerOneIndices.containsPossibilities(split[2]) )
        }
        Assert.assertEquals(true,playerOneWins)
    }

    @Test
    fun testWhoWinsWithPlayerOneCheckJustFirstDiagonally() {
        var  playerOneWins = false
        game.mPlayerOne = Player("player one",Type.TYPE_X)
        if(game.atLeast5FilledCases()) {
            var playerOneIndices = game.getIndices(game.mPlayerOne!!.type)
            var possibilities = game.getIndicesForDiagonally(0,4,3)
            var split = possibilities.split("-")
            playerOneWins = playerOneIndices.containsPossibilities(split[0])
        }
        Assert.assertEquals(false,playerOneWins)
    }

    @Test
    fun testWhoWinsWithPlayerOneCheckJustSecondDiagonally() {
        var  playerOneWins = false
        game.mPlayerOne = Player("player one",Type.TYPE_X)
        if(game.atLeast5FilledCases()) {
            var playerOneIndices = game.getIndices(game.mPlayerOne!!.type)
            var possibilities = game.getIndicesForDiagonally(2,2,3)
            var split = possibilities.split("-")
            playerOneWins = playerOneIndices.containsPossibilities(split[0])
        }
        Assert.assertEquals(true,playerOneWins)
    }

    @Test
    fun testCreatefunctionToApplyAllRulesForPlayerTwo() {
        game.mPlayerTwo = Player("player two",Type.TYPE_O)
        var wins = false
        var playerTwoIndices = game.getIndices(game.mPlayerTwo!!.type)
        val possibilityRows = game.getIndicesForElement(3,1,3)
        val possibilityColumns = game.getIndicesForElement(1,3,3)
        val possibilityFirstDiag = game.getIndicesForDiagonally(0,4,3)
        val possibilitySecondDiag = game.getIndicesForDiagonally(2,2,3)
        println("$playerTwoIndices")
        println("$possibilityRows")
        println("$possibilityColumns")
        println("$possibilityFirstDiag")
        println("$possibilitySecondDiag")
        wins = game.verifyElement(playerTwoIndices,possibilityRows)
        println("$wins")
        if(!wins) wins = game.verifyElement(playerTwoIndices,possibilityColumns)
        println("$wins")
        if(!wins) wins = game.verifyDiagonally(playerTwoIndices,possibilityFirstDiag)
        println("$wins")
        if(!wins) wins = game.verifyDiagonally(playerTwoIndices,possibilitySecondDiag)
        println("$wins")
        Assert.assertEquals(false,wins)
    }

    @Test
    fun testNineFilledGameIsDraw() {
        game.mPlayerTwo = Player("player two",Type.TYPE_O)
        game.mPlayerOne = Player("player one",Type.TYPE_X)
        game.mBoard[0] = Type.TYPE_X
        game.mBoard[1] = Type.TYPE_O
        game.mBoard[2] = Type.TYPE_X
        game.mBoard[3] = Type.TYPE_X
        game.mBoard[4] = Type.TYPE_O
        game.mBoard[5] = Type.TYPE_X
        game.mBoard[6] = Type.TYPE_O
        game.mBoard[7] = Type.TYPE_X
        game.mBoard[8] = Type.TYPE_O
        val conditions = (game.whoWins() == null && game.isBoardFilled())
        Assert.assertEquals(true,conditions)
    }
}