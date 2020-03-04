package com.example.tictactoe.models

class Game() {
    var board: HashMap<Int,String>
    var mNumberRows: Int? = null
    var mNumberColumns: Int? = null
    var player: Player? = null

    init {
        board = HashMap()
    }
}