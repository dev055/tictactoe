package com.example.tictactoe.utils

import java.lang.StringBuilder

object StringUtil {
    fun String.containsPossibilities(possibilities: String): Boolean {
        var splitPossibilities = possibilities.split(" ")
        var index = 0
        var contains = true
        do {
            contains = this.contains(splitPossibilities[index])
            index++
        }while (index < splitPossibilities.size && contains)
        return contains
    }
}