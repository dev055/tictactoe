package com.example.tictactoe.models

class ManageIndice() {
    var number: Int? = null
    var end: Int? = null
    var result = StringBuilder()

    constructor(number: Int, end: Int): this() {
        this.end = end
        this.number = number
    }
}