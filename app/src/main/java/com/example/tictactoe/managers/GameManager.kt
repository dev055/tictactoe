package com.example.tictactoe.managers

import com.example.tictactoe.listeners.IDialogListener
import com.example.tictactoe.listeners.IViewListener
import com.example.tictactoe.models.Game
import com.example.tictactoe.models.Player
import com.example.tictactoe.models.Type

object GameManager {
    private var number = 3
    private var mGame: Game? = null
    private var mListeners = ArrayList<IViewListener>()
    private var mDialogListeners = ArrayList<IDialogListener>()

    fun getGame(): Game? = mGame

    fun addListener(listener: IViewListener) { mListeners.add(listener) }
    fun addDialogListener(listener: IDialogListener) { mDialogListeners.add(listener) }

    fun createPlayer(playerOneName: String, playerTwoName: String) {
        mGame = Game(number, number)
        mGame!!.mPlayerOne = Player(playerOneName,Type.TYPE_X)
        mGame!!.mPlayerTwo = Player(playerTwoName,Type.TYPE_O)
        mListeners.forEach { listener -> listener.goNextView() }
    }

    fun endOfGame() {
        mDialogListeners.forEach { listener -> listener.show() }
    }
}