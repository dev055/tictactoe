package com.example.tictactoe.models

import java.lang.StringBuilder

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
    fun getIndices(type: Int): String{
        val result = mBoard.filterValues { it.type == type }.keys.toList()
        var str = StringBuilder()
        result.forEach { k -> str.append("$k ") }
        str.deleteCharAt(str.length.minus(1))
        return str.toString()
    }

    /**
     * Try to retrieve indices for Rows
     */
    /*fun indicesForRows(): String {
        var row = 0
        val manageIndice = ManageIndice(mNumberRows!!)
        for(x in 0..manageIndice.mEnd!!) {
            var indexToSave = row
            var start = row
            for(start in 0..manageIndice.mEnd!!) {
                manageIndice.mResult.append("$indexToSave ")
                indexToSave += 1
            }
            manageIndice.mResult.deleteCharAt(manageIndice.mResult.length.minus(1))
            manageIndice.mResult.append("-")
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
    */

    /**
     * Retrieve indices for Rows or Columns
     * Rows : 3,1,3
     * Columns: 1,3,3
     * @param addForElement value to add to next element
     * @param addForIndex value to add to index
     * @param number number of elements
     * @return String
     */
    fun getIndicesForElement(addForElement: Int, addForIndex: Int, number: Int): String{
        var element = 0
        var end = number.minus(1)
        var result = StringBuilder()
        for(x in 0..end) {
            var indexToSave = element
            var start = element
            for(start in 0..end) {
                result.append("$indexToSave ")
                indexToSave += addForIndex
            }
            result.deleteCharAt(result.length.minus(1))
            result.append("-")
            element += addForElement
        }
        result.deleteCharAt(result.length.minus(1))
        return result.toString()
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

    fun areyouwin(type: Int): Boolean {
        val indices = getIndices(type)
        val rowsIndices = indicesForRows()
        val splited = rowsIndices.split("-")
        var condition = indices.contains(splited[0]).or(indices.contains(splited[1])).or(indices.contains(splited[2]))
        return condition
    }
}