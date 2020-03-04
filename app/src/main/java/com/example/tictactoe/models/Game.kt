package com.example.tictactoe.models

class Game() {
    var board: HashMap<Int,String>
    var mNumberRows: Int? = null
    var mNumberColumns: Int? = null

    init {
        board = HashMap()
    }
}