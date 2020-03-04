package com.example.tictactoe.models

class Game() {
    var mBoard: HashMap<Int,Player>
    var mNumberRows: Int? = null
    var mNumberColumns: Int? = null
    var mPlayerOne: Player? = null
    var mPlayerTwo: Player? = null

    init {
        mBoard = HashMap()
    }

    fun isBoardFilled(): Boolean {
        return mBoard.size == 9
    }

    fun getValuesX() {
        mBoard.filterValues { it.type == "X" }
    }

    fun getValuesO() {
        mBoard.filterValues { it.type == "O" }
    }
}