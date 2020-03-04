package com.example.tictactoe

import com.example.tictactoe.models.Game
import org.junit.Assert
import org.junit.Test

class GameTest {

    @Test
    fun testIfGameExists() {
        Assert.assertEquals(true, Game() != null)
    }

}