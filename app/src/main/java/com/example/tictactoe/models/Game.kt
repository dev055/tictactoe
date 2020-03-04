package com.example.tictactoe.models

class Game() {
    var board: HashMap<Int,String>
    var mNumberRows: Int? = null
    var mNumberColumns: Int? = null
    var playerOne: Player? = null
    var playerTwo: Player? = null

    init {
        board = HashMap()
    }
}