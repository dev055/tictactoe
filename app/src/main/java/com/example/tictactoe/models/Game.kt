package com.example.tictactoe.models

import java.lang.StringBuilder
import com.example.tictactoe.utils.StringUtil.containsPossibilities

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

    constructor(numberRows: Int, numberColumns: Int): this() {
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

    /*fun areyouwin(type: Int): Boolean {
        val indices = getIndices(type)
        val rowsIndices = getIndicesForElement(3,1,3)
        val splited = rowsIndices.split("-")
        var condition = indices.contains(splited[0]).or(indices.contains(splited[1])).or(indices.contains(splited[2]))
        return condition
        return false
    }
    */

    fun whoWins(): Player? {
        if(atLeast5FilledCases()) {
            var playerOneWins = false
            var playerTwoWins = false
            val playerOneIndices = getIndices(mPlayerOne!!.type)
            val playerTwoIndices = getIndices(mPlayerTwo!!.type)

            var rowsPossibilities = getIndicesForElement(3,1,3)
            var split = rowsPossibilities.split(" ")
            var columnsPossibilities = getIndicesForElement(1,3,3)
            split = columnsPossibilities.split(" ")
            var firstDiagonally = getIndicesForDiagonally(0,4,3)
            split = firstDiagonally.split(" ")
            var secondDiagonally = getIndicesForDiagonally(2,2,3)
            split = secondDiagonally.split(" ")

            playerOneWins = (playerOneIndices.containsPossibilities(split[0])
                    || playerOneIndices.containsPossibilities(split[1])
                    || playerOneIndices.containsPossibilities(split[2]) )
            if(!playerOneWins) {
                playerOneWins = (playerOneIndices.containsPossibilities(split[0])
                        || playerOneIndices.containsPossibilities(split[1])
                        || playerOneIndices.containsPossibilities(split[2]) )
            }
            if(!playerOneWins) {
                playerOneWins = playerOneIndices.containsPossibilities(split[0])
            }
            if(!playerOneWins) {
                playerOneWins = playerOneIndices.containsPossibilities(split[0])
            }

            playerTwoWins = (playerTwoIndices.containsPossibilities(split[0])
                    || playerOneIndices.containsPossibilities(split[1])
                    || playerOneIndices.containsPossibilities(split[2]) )
            if(!playerTwoWins) {
                playerTwoWins = (playerTwoIndices.containsPossibilities(split[0])
                        || playerOneIndices.containsPossibilities(split[1])
                        || playerOneIndices.containsPossibilities(split[2]) )
            }
            if(!playerTwoWins) {
                playerTwoWins = playerTwoIndices.containsPossibilities(split[0])
            }

            if(!playerTwoWins) {
                playerTwoWins = playerTwoIndices.containsPossibilities(split[0])
            }

            if(playerOneWins) return mPlayerOne
            if(playerTwoWins) return mPlayerTwo
        }
        return null
    }
}