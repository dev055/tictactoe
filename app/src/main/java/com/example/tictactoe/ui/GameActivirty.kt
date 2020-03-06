package com.example.tictactoe.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tictactoe.R
import com.example.tictactoe.managers.GameManager
import com.example.tictactoe.models.Case
import com.example.tictactoe.models.Game
import com.example.tictactoe.ui.adapters.GameAdapter
import kotlinx.android.synthetic.main.activity_game.*

class GameActivirty: AppCompatActivity() {
    companion object {
        fun newIntent(context: Context): Intent = Intent(context,GameActivirty::class.java)
    }
    private lateinit var adapter: GameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
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
                                playerone.setBackgroundResource(R.color.color_grey_two)
                            } else {
                                playertwo.setBackgroundResource(R.color.color_grey_two)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun initializeRecyclerview() {
        GameManager.run {
            getGame()?.let { game ->
                game_recyclerview_id?.let { recycler ->
                    adapter = GameAdapter(this@GameActivirty)
                    recycler.layoutManager = GridLayoutManager(this@GameActivirty,game.mNumberColumns!!)
                    recycler.adapter = adapter

                    var cases = ArrayList<Case>()
                    for(x in 0..game.mTotal!!.minus(1)) {
                        cases.add(Case())
                    }
                    adapter.setItems(cases)
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
                    if(game.atLeast5FilledCases()) {

                    }
                } else {
                    Toast.makeText(this@GameActivirty,getString(R.string.game_case_filled),Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun nextPlayer(game: Game) {
        //TODO check property finish
        game.whoPlays()
        setCurrentPlayerNameColor()
    }
}