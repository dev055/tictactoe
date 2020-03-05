package com.example.tictactoe

import com.example.tictactoe.models.Game
import com.example.tictactoe.models.GameManagerForTesting
import com.example.tictactoe.models.Player
import com.example.tictactoe.models.Type
import com.example.tictactoe.utils.PlayerNameUtil
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GameManagerTest {
    private var gameManagerForTesting = GameManagerForTesting()

    @Before
    fun setup() {
        gameManagerForTesting.mGame = Game()
    }

    @Test
    fun testIfGameManagerContainsGame() {
        Assert.assertEquals(true,gameManagerForTesting.mGame != null)
    }

    @Test
    fun testIfGameHasPlayerFromName() {
        gameManagerForTesting.mGame!!.mPlayerOne = Player("player 1",Type.TYPE_X)
        gameManagerForTesting.mGame!!.mPlayerTwo = Player("player 2",Type.TYPE_O)
        val condition = (gameManagerForTesting.mGame!!.mPlayerOne != null && gameManagerForTesting.mGame!!.mPlayerTwo != null)
        Assert.assertEquals(true,condition)
    }

    @Test
    fun testCreatingPlayerFromEmptyName() {
        val playerOne = PlayerNameUtil.defaultName("")
        val playerTwo = PlayerNameUtil.defaultName("")
        gameManagerForTesting.mGame!!.mPlayerOne = Player(playerOne,Type.TYPE_X)
        gameManagerForTesting.mGame!!.mPlayerTwo = Player(playerTwo,Type.TYPE_O)
        Assert.assertEquals(true,gameManagerForTesting.mGame!!.mPlayerTwo!!.name == "player 2")
    }

    @Test
    fun testIfManagerHasViewListener() {
        Assert.assertEquals(true, gameManagerForTesting.listeners!= null)
    }

    @Test
    fun testPlayerTwoHasDefaultName() {
        val playerOne = PlayerNameUtil.defaultName("adn")
        val playerTwo = PlayerNameUtil.defaultName("")
        gameManagerForTesting.mGame!!.mPlayerOne = Player(playerOne,Type.TYPE_X)
        gameManagerForTesting.mGame!!.mPlayerTwo = Player(playerTwo,Type.TYPE_O)
        val condition = (gameManagerForTesting.mGame!!.mPlayerTwo!!.name == "player 2" && gameManagerForTesting.mGame!!.mPlayerOne!!.name == "adn")
        Assert.assertEquals(true,condition)
    }

    @Test
    fun testPlayerOneHasDefaultName() {
        val playerOne = PlayerNameUtil.defaultName("")
        val playerTwo = PlayerNameUtil.defaultName("ndaa")
        gameManagerForTesting.mGame!!.mPlayerOne = Player(playerOne,Type.TYPE_X)
        gameManagerForTesting.mGame!!.mPlayerTwo = Player(playerTwo,Type.TYPE_O)
        val condition = (gameManagerForTesting.mGame!!.mPlayerTwo!!.name == "ndaa" && gameManagerForTesting.mGame!!.mPlayerOne!!.name == "player 1")
        Assert.assertEquals(true,condition)
    }
}