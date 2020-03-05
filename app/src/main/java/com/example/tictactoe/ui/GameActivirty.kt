package com.example.tictactoe.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.R

class GameActivirty: AppCompatActivity() {
    companion object {
        fun newIntent(context: Context): Intent = Intent(context,GameActivirty::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

}