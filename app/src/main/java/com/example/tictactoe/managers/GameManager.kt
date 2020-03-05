package com.example.tictactoe.managers

import com.example.tictactoe.models.Game
import com.example.tictactoe.models.Player
import com.example.tictactoe.models.Type

object GameManager {
    private var mGame: Game? = null

    fun createPlayer(playerOneName: String, playerTwoName: String) {
        mGame = Game()
        mGame!!.mPlayerOne = Player(playerOneName,Type.TYPE_X)
        mGame!!.mPlayerTwo = Player(playerTwoName,Type.TYPE_O)
    }
}