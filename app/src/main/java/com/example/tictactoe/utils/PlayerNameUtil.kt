package com.example.tictactoe.utils

object PlayerNameUtil {
    private var playerCounter = 1
    private var default = "player"

    fun defaultName(name: String): String {
        var result = name
        if(name.isEmpty()) {
            result = "$default $playerCounter"
        }
        return result
    }
}