package com.example.tictactoe.utils

import java.lang.StringBuilder

object StringUtil {
    private var totalCpt = 3
    fun String.containsPossibilities(possibilities: String): Boolean {
        var splitPossibilities = possibilities.split(" ")
        var index = 0
        var contains = true
        var cpt = 0
        do {
            contains = this.contains(splitPossibilities[index])
            if(contains) cpt++
            index++
        }while (index < splitPossibilities.size && contains)
        return (contains && totalCpt == cpt)
    }
}