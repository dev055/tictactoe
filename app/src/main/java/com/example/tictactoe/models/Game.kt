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
        val manageIndice = ManageIndice(mNumberRows!!)
        for(x in 0..manageIndice.mEnd!!) {
            var indexToSave = row
            var start = row
            for(start in 0..manageIndice.mEnd!!) {
                manageIndice.mResult.append("$indexToSave ")
                indexToSave += 1
            }
            row += 3
        }
        manageIndice.mResult.deleteCharAt(manageIndice.mResult.length.minus(1))
        return manageIndice.mResult.toString()
    }

    /**
     * Retrieve indices for columns
     */
    fun indicesForColumns(): String {
        var column = 0
        val manageIndice = ManageIndice(mNumberRows!!)
        for(x in 0..manageIndice.mEnd!!) {
            var indexToSave = column
            var start = column
            for(start in 0..manageIndice.mEnd!!) {
                manageIndice.mResult.append("$indexToSave ")
                indexToSave += 3
            }
            column += 1
        }
        manageIndice.mResult.deleteCharAt(manageIndice.mResult.length.minus(1))
        return manageIndice.mResult.toString()
    }

    /**
     * indices for diagonally
     */
    fun indicesForFirstDiagonally(): String {
        var diagonally = 0
        val manageIndice = ManageIndice(mNumberRows!!)
        var indexToSave = diagonally
        for(x in 0..manageIndice.mEnd!!) {
            manageIndice.mResult.append("$indexToSave ")
            indexToSave += 4
        }
        manageIndice.mResult.deleteCharAt(manageIndice.mResult.length.minus(1))
        return manageIndice.mResult.toString()
    }

    /**
     * indices for reverse diagonally
     */
    fun indicesForSecondDiagonally(): String {
        var diagonally = 2
        val manageIndice = ManageIndice(mNumberRows!!)
        var indexToSave = diagonally
        for(x in 0..manageIndice.mEnd!!) {
            manageIndice.mResult.append("$indexToSave ")
            indexToSave += 2
        }
        manageIndice.mResult.deleteCharAt(manageIndice.mResult.length.minus(1))
        return manageIndice.mResult.toString()
    }

}