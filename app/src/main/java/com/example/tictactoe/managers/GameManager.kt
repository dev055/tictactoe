package com.example.tictactoe.managers

import android.util.Log
import com.example.tictactoe.listeners.IDialogListener
import com.example.tictactoe.listeners.IViewListener
import com.example.tictactoe.models.Game
import com.example.tictactoe.models.Player
import com.example.tictactoe.models.Type
import java.lang.IllegalArgumentException

object GameManager {
    private var number = 4
    private var mGame: Game? = null
    private var mListeners = ArrayList<IViewListener>()
    private var mDialogListeners = ArrayList<IDialogListener>()

    fun getGame(): Game? = mGame

    fun addListener(listener: IViewListener) { mListeners.add(listener) }
    fun addDialogListener(listener: IDialogListener) { mDialogListeners.add(listener) }

    fun createPlayer(playerOneName: String, playerTwoName: String) {
        val playerOne = Player(playerOneName,Type.TYPE_X)
        val playerTwo = Player(playerTwoName,Type.TYPE_O)
        try {
            mGame = Game(number, number,playerOne,playerTwo)
        }catch (i: IllegalArgumentException) {
            i.printStackTrace()
            Log.e("Error","${i.message}")
            mGame = Game(3, 3,playerOne, playerTwo)
        }
        mListeners.forEach { listener -> listener.goNextView() }
    }

    fun endOfGame() {
        mDialogListeners.forEach { listener -> listener.show() }
    }
}