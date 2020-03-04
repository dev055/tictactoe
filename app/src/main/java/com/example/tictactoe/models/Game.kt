package com.example.tictactoe.models

class Game() {
    var mBoard: HashMap<Int,Player>
    var mNumberRows: Int? = null
    var mNumberColumns: Int? = null
    var mTotal: Int? = null
    var mPlayerOne: Player? = null
    var mPlayerTwo: Player? = null

    init {
        mBoard = HashMap()
    }

    constructor(numberRows: Int, numberColumns: Int): this() {
        this.mNumberRows = numberRows
        this.mNumberColumns = numberColumns
        this.mTotal = this.mNumberRows!!.times(this.mNumberColumns!!)
        this.mBoard = HashMap()
    }

    fun isBoardFilled(): Boolean {
        return mBoard.size == 9
    }

    /**
     * Retrieve indices for a specific type
     */
    fun getIndices(type: Int) {
        mBoard.filterValues { it.type == Type.TYPE_O }
    }

    /**
     * Try to retrieve indices for Rows
     */
    fun indicesForRows(): String {
        var row = 0
        var end = mNumberRows!!.minus(1)
        var stringBuilder = StringBuilder()
        for(x in 0..end) {
            var indexToSave = row
            var start = row
            for(start in 0..end) {
                stringBuilder.append("$indexToSave ")
                indexToSave += 1
            }
            row += 3
        }
        stringBuilder.deleteCharAt(stringBuilder.length.minus(1))
        return stringBuilder.toString()
    }

    /**
     * Retrieve indices for columns
     */
    fun indicesForColumns(): String {
        var column = 0
        var end = mNumberColumns!!.minus(1)
        var stringBuilder = StringBuilder()
        for(x in 0..end) {
            var indexToSave = column
            var start = column
            for(start in 0..end) {
                stringBuilder.append("$indexToSave ")
                indexToSave += 3
            }
            column += 1
        }
        stringBuilder.deleteCharAt(stringBuilder.length.minus(1))
        return stringBuilder.toString()
    }

    /**
     * indices for diagonally
     */
    fun indicesForFirstDiagonally(): String {
        var diagonally = 0
        var end = mNumberColumns!!.minus(1)
        var start = 0
        var stringBuilder = StringBuilder()
        var indexToSave = diagonally
        for(x in 0..end) {
            stringBuilder.append("$indexToSave ")
            indexToSave += 4
        }
        stringBuilder.deleteCharAt(stringBuilder.length.minus(1))
        return stringBuilder.toString()
    }

    /**
     * indices for reverse diagonally
     */
    fun indicesForSecondDiagonally(): String {
        var diagonally = 2
        var end = mNumberColumns!!.minus(1)
        var start = 0
        var stringBuilder = StringBuilder()
        var indexToSave = diagonally
        for(x in 0..end) {
            stringBuilder.append("$indexToSave ")
            indexToSave += 2
        }
        stringBuilder.deleteCharAt(stringBuilder.length.minus(1))
        return stringBuilder.toString()
    }
}