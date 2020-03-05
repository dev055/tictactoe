package com.example.tictactoe

import org.junit.Assert
import org.junit.Test

class PlayerNameTest {
    private var playerCounter = 1
    private var firstPart = "player"

    @Test
    fun testCreateDefaultNameForPlayerOne() {
        val emptyName = ""
        var defaultName = ""
        if(emptyName.isEmpty()) {
            defaultName = "$firstPart $playerCounter"
        }
        Assert.assertEquals(true,defaultName == "player 1")
    }
}