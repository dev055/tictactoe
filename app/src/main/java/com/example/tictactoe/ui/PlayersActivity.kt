package com.example.tictactoe.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tictactoe.R
import com.example.tictactoe.utils.PlayerNameUtil
import kotlinx.android.synthetic.main.activity_players.*

class PlayersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)
        manageView()
    }

    private fun manageView() {
        players_button_lets_go_id?.let { btn ->
            btn.setOnClickListener {
                players_player_one_id?.let { playerone ->
                    players_player_two_id?.let { playertwo ->
                        Log.d("debug","${PlayerNameUtil.defaultName(playerone.text.toString())} - ${PlayerNameUtil.defaultName(playertwo.text.toString())}")
                    }
                }
            }
        }
    }
}
