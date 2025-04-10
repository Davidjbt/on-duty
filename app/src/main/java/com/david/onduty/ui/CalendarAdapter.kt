package com.david.onduty.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.david.onduty.R
import kotlin.random.Random

class CalendarAdapter(private val dataSet: Array<Int>) : RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dayView: TextView
        val eventsDotsLayout: LinearLayout

        init {
            dayView = view.findViewById(R.id.dayView)
            eventsDotsLayout = view.findViewById(R.id.eventDotsLayout)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.day, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dayView.text = dataSet[position].toString()

        for (i in 1..Random.nextInt(1, 5)) {

            if (i == 4) {
                val eventPlusView = ImageView(holder.itemView.context).apply {
                    setImageResource(R.drawable.event_plus)
                }

                holder.eventsDotsLayout.addView(eventPlusView)
                break
            } else {
                val eventDotView = ImageView(holder.itemView.context).apply {
                    setImageResource(R.drawable.event_dot)
                    setColorFilter(Color.BLUE)
                }

                holder.eventsDotsLayout.addView(eventDotView)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}