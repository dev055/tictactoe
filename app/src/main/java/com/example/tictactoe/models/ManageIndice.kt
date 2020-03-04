package com.example.tictactoe.models

class ManageIndice() {
    var mEnd: Int? = null
    var mNumber: Int? = null
    var mResult = StringBuilder()

    constructor(number: Int): this() {
        this.mNumber = number
        this.mEnd = this.mNumber!!.minus(1)
    }
}