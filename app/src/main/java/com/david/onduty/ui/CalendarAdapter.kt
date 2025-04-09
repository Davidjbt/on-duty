package com.david.onduty.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.david.onduty.R

class CalendarAdapter(private val dataSet: Array<Int>) : RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dayView: TextView

        init {
            dayView = view.findViewById(R.id.dayView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.day, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dayView.text = dataSet[position].toString()
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}