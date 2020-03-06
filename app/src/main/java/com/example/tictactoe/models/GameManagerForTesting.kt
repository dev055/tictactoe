package com.example.tictactoe.models

import com.example.tictactoe.listeners.IDialogListener
import com.example.tictactoe.listeners.IViewListener

class GameManagerForTesting {
    var mGame: Game? = null
    var listeners = ArrayList<IViewListener>()
    var dialogListeners = ArrayList<IDialogListener>()
}