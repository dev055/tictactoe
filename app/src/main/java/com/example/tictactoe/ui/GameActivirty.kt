package com.example.tictactoe.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tictactoe.R
import com.example.tictactoe.managers.GameManager
import com.example.tictactoe.models.Case
import com.example.tictactoe.models.Player
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
                game.whoPlays()
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
                game.savePosition(position, case.type!!)
                adapter.notifyItemChanged(position)
                game.whoPlays()
            }
        }
    }
}