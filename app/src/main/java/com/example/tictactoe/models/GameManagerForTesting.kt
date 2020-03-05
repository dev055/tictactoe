package com.example.tictactoe.models

import com.example.tictactoe.listeners.IViewListener

class GameManagerForTesting {
    var mGame: Game? = null
    var listeners = ArrayList<IViewListener>()

    fun addListener(listener: IViewListener) { listeners.add(listener) }
}