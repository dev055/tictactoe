package com.example.tictactoe.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.R
import com.example.tictactoe.managers.GameManager
import kotlinx.android.synthetic.main.activity_game.*

class GameActivirty: AppCompatActivity() {
    companion object {
        fun newIntent(context: Context): Intent = Intent(context,GameActivirty::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        manageView()
    }

    private fun manageView() {
        GameManager.run {
            getGame()?.let { game ->
                game_player_one_id?.text = game.mPlayerOne!!.name
                game_player_two_id?.text = game.mPlayerTwo!!.name
            }
        }
    }
}