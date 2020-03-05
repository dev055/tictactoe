package com.example.tictactoe.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tictactoe.R
import com.example.tictactoe.models.Case
import com.example.tictactoe.models.Type

class GameAdapter(private val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mItems = ArrayList<Case>()
    private var fn: ((Case,Int) -> Unit)? = null

    fun setFunction(fn: ((Case,Int) -> Unit)) { this.fn = fn }
    fun setItems(cases: ArrayList<Case>) {
        this.mItems = cases
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_game,parent,false)
        return GameViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as GameViewHolder
        val case = mItems[position]
        case.type?.let { setType(holder.caseView,it) }
        holder.mainView.setOnClickListener { fn!!.invoke(case,position) }
    }

    private fun setType(view: TextView, type: Int) {
        when(type) {
            Type.TYPE_X -> { view.text = " X " }
            Type.TYPE_O -> { view.text = " O " }
            else -> {}
        }
    }

    class GameViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val mainView = view.findViewById<LinearLayout>(R.id.item_game_main_view_id)
        val caseView = view.findViewById<TextView>(R.id.item_game_case_id)
    }
}