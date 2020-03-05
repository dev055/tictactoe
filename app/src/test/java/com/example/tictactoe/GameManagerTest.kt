package com.example.tictactoe

import com.example.tictactoe.models.Game
import com.example.tictactoe.models.GameManagerForTesting
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
}