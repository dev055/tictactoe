package com.example.tictactoe.models

import java.lang.StringBuilder
import com.example.tictactoe.utils.StringUtil.containsPossibilities
import java.lang.IllegalArgumentException

class Game() {
    var mBoard: HashMap<Int,Int>
    var mNumberRows: Int? = null
    var mNumberColumns: Int? = null
    var mTotal: Int? = null
    var mPlayerOne: Player? = null
    var mPlayerTwo: Player? = null
    var mCurrent: Player? = null

    init {
        mBoard = HashMap()
    }

    constructor(numberRows: Int, numberColumns: Int, playerOne: Player, playerTwo: Player): this() {
        if(numberRows != 3 || numberColumns != 3) throw IllegalArgumentException("rows and columns must equal to 3 !")
        mPlayerTwo = playerTwo
        mPlayerOne = playerOne
        this.mNumberRows = numberRows
        this.mNumberColumns = numberColumns
        this.mTotal = this.mNumberRows!!.times(this.mNumberColumns!!)
        this.mBoard = HashMap()
    }

    fun isBoardFilled(): Boolean {
        return mBoard.size == 9
    }

    fun atLeast5FilledCases(): Boolean {
        return mBoard.size >= 5
    }

    fun savePosition(position: Int, type: Int): Boolean {
        if(mBoard[position] != null) return false
        mBoard[position] = type
        return true
    }

    /**
     * Retrieve indices for a specific type
     */
    fun getIndices(type: Int): String{
        val result = mBoard.filterValues { it == type }.keys.toList()
        var str = StringBuilder()
        result.forEach { k -> str.append("$k ") }
        str.deleteCharAt(str.length.minus(1))
        return str.toString()
    }

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
     * Retrieve indices for diagonally
     * first: 0,4,3
     * second: 2,2,3
     * @param element
     * @param addForIndex
     * @param number
     * @return String
     */
    fun getIndicesForDiagonally(element: Int, addForIndex: Int, number: Int): String {
        var end = number.minus(1)
        var result = StringBuilder()
        var indexToSave = element
        for(x in 0..end) {
            result.append("$indexToSave ")
            indexToSave += addForIndex
        }
        result.deleteCharAt(result.length.minus(1))
        return result.toString()
    }

    fun whoPlays() {
        if(mCurrent == null) {
            mCurrent = mPlayerOne
        } else {
            if (mCurrent!!.name == mPlayerOne!!.name)
                mCurrent = mPlayerTwo
            else
                mCurrent = mPlayerOne
        }
    }

    fun verifyElement(indices: String, possibilities: String, reg: String = "-"): Boolean{
        val split = possibilities.split(reg)
        return (indices.containsPossibilities(split[0])
                || indices.containsPossibilities(split[1])
                || indices.containsPossibilities(split[2]) )
    }

    fun verifyDiagonally(indices: String, possibilities: String): Boolean{
        return indices.containsPossibilities(possibilities)
    }

    fun applyRules(indices: String, rows: String, columns: String, firstDiagonally: String, secondDiagonally: String): Boolean {
        var wins = verifyElement(indices,rows)
        if(!wins)
            wins = verifyElement(indices,columns)
        if(!wins)
            wins = verifyDiagonally(indices,firstDiagonally)
        if(!wins)
            wins = verifyDiagonally(indices,secondDiagonally)
        return wins
    }

    fun whoWins(): Player? {
        if(atLeast5FilledCases()) {
            var playerOneWins = false
            var playerTwoWins = false
            val playerOneIndices = getIndices(mPlayerOne!!.type)
            val playerTwoIndices = getIndices(mPlayerTwo!!.type)

            var rowsPossibilities = getIndicesForElement(3,1,3)
            var columnsPossibilities = getIndicesForElement(1,3,3)
            var firstDiagonally = getIndicesForDiagonally(0,4,3)
            var secondDiagonally = getIndicesForDiagonally(2,2,3)

            playerOneWins = applyRules(playerOneIndices,rowsPossibilities,columnsPossibilities,firstDiagonally,secondDiagonally)
            playerTwoWins = applyRules(playerTwoIndices,rowsPossibilities,columnsPossibilities,firstDiagonally,secondDiagonally)

            if(playerOneWins) return mPlayerOne
            if(playerTwoWins) return mPlayerTwo
        }
        return null
    }

    fun resetGame() {
        mBoard.clear()
        mPlayerOne = null
        mPlayerTwo = null
        mNumberColumns = null
        mNumberRows = null
        mTotal = null
    }
}