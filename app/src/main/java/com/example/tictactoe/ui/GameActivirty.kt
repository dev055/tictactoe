package com.example.tictactoe.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tictactoe.R
import com.example.tictactoe.listeners.IDialogListener
import com.example.tictactoe.managers.GameManager
import com.example.tictactoe.models.Case
import com.example.tictactoe.models.Game
import com.example.tictactoe.ui.adapters.GameAdapter
import kotlinx.android.synthetic.main.activity_game.*

class GameActivirty: AppCompatActivity(),IDialogListener {
    override fun show() {
        val customLayout = LayoutInflater.from(this).inflate(R.layout.dialog_layout,null,false)
        val alertDialog = AlertDialog.Builder(this)
            .setTitle(getString(R.string.dialog_title))
            .setCancelable(true)
            .setView(customLayout)
            .create()
        customLayout.apply {
            findViewById<TextView>(R.id.dialog_layout_replay_id).setOnClickListener {
                replay()
                alertDialog.dismiss()
            }
            findViewById<TextView>(R.id.dialog_layout_new_game_id).setOnClickListener {
                GameManager.getGame()?.resetGame()
                finish()
                alertDialog.dismiss()
            }
        }
        if(!this.isFinishing) alertDialog.show()
    }

    companion object {
        fun newIntent(context: Context): Intent = Intent(context,GameActivirty::class.java)
    }
    private lateinit var adapter: GameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        GameManager.addDialogListener(this)
        manageView()
        initializeRecyclerview()
    }

    private fun manageView() {
        GameManager.run {
            getGame()?.let { game ->
                game_player_one_id?.text = game.mPlayerOne!!.name
                game_player_two_id?.text = game.mPlayerTwo!!.name
                nextPlayer(game)
            }
        }
    }

    private fun setCurrentPlayerNameColor() {
        game_player_one_id?.let { playerone ->
            game_player_two_id?.let { playertwo ->
                playerone.setBackgroundResource(R.color.color_grey_one)
                playertwo.setBackgroundResource(R.color.color_grey_one)
                GameManager.run {
                    getGame()?.let { game ->
                        game.mCurrent?.let { c ->
                            if (c.name == game.mPlayerOne!!.name) {
                                playerone.setBackgroundResource(R.color.color_red_one)
                            } else {
                                playertwo.setBackgroundResource(R.color.color_black)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun createDefaultCases(game: Game): ArrayList<Case>{
        var cases = ArrayList<Case>()
        for(x in 0..game.mTotal!!.minus(1)) {
            cases.add(Case())
        }
        return cases
    }

    private fun initializeRecyclerview() {
        GameManager.run {
            getGame()?.let { game ->
                game_recyclerview_id?.let { recycler ->
                    adapter = GameAdapter(this@GameActivirty)
                    recycler.layoutManager = GridLayoutManager(this@GameActivirty,game.mNumberColumns!!)
                    recycler.adapter = adapter

                    adapter.setItems(createDefaultCases(game))
                    adapter.setFunction { case, i -> clickEventOnBoard(case,i) }
                }
            }
        }
    }

    private fun clickEventOnBoard(case: Case, position: Int) {
        GameManager.run {
            getGame()?.let { game ->
                case.type = game.mCurrent!!.type
                if(game.savePosition(position, case.type!!)) {
                    adapter.notifyItemChanged(position)
                    nextPlayer(game)
                    val player = game.whoWins()
                    if(player != null) {
                        Toast.makeText(this@GameActivirty,getString(R.string.game_won,player!!.name),Toast.LENGTH_SHORT).show()
                        endOfGame()
                    } else if(game.isBoardFilled()) {
                        Toast.makeText(this@GameActivirty,getString(R.string.game_is_draw),Toast.LENGTH_SHORT).show()
                        endOfGame()
                    }
                } else {
                    Toast.makeText(this@GameActivirty,getString(R.string.game_case_filled),Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun nextPlayer(game: Game) {
        game.whoPlays()
        setCurrentPlayerNameColor()
    }

    private fun replay() {
        GameManager.getGame()?.let { game ->
            adapter.setItems(createDefaultCases(game))
            game.mBoard.clear()
            game.mCurrent = null
            nextPlayer(game)
        }
    }
}