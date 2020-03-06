package com.example.tictactoe

import org.junit.Assert
import org.junit.Test

class StringTest {
    private var possibilities = "3 4 5"

    @Test
    fun testIfContainsPossibilities() {
        val split = possibilities.split(" ")
        var indices = "0 5 7 3 2 1 4"
        var inlist = true
        var index = 0
        do {
            inlist = indices.contains(split[index])
            index++
        }while(inlist && index < split.size)
        Assert.assertEquals(true,inlist)
    }
}