package com.example.tictactoe

import org.junit.Assert
import org.junit.Test

class StringTest {
    private var possibilities = "3 4 5"
    private var totalCpt = 3

    @Test
    fun testIfContainsPossibilities() {
        val split = possibilities.split(" ")
        var indices = "0 5 7 3 2 1 4"
        var inlist = true
        var index = 0
        var cpt = 0
        do {
            inlist = indices.contains(split[index])
            if(inlist) cpt++
            index++
        }while(inlist && index < split.size)
        val condition = (cpt == totalCpt && inlist)
        Assert.assertEquals(true,condition)
    }
}