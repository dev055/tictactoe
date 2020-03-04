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

    fun getIndices(type: Int) {
        mBoard.filterValues { it.type == Type.TYPE_O }
    }
}