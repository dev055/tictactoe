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

    @Test
    fun testCreateDefaultNameForPlayerTwo() {
        val emptyName = ""
        var defaultNameOne = "$firstPart $playerCounter"
        playerCounter++
        var defaultNameTwo = "$firstPart $playerCounter"
        Assert.assertEquals(true,defaultNameTwo == "player 2")
    }

    @Test
    fun testAfterCreatingDefaultNamesCounterisOne() {
        val emptyName = ""
        var defaultNameOne = "$firstPart $playerCounter"
        playerCounter++
        var defaultNameTwo = "$firstPart $playerCounter"
        playerCounter = 1
        Assert.assertEquals(true,playerCounter == 1)
    }
}