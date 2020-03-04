package com.example.tictactoe.models

class Game() {
    lateinit var board: HashMap<Int,String>
    init {
        board = HashMap()
    }
}