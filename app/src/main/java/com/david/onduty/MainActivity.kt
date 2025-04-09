package com.david.onduty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.david.onduty.ui.CalendarAdapter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataSet = arrayOf(1, 2, 3)
        val adapter = CalendarAdapter(dataSet)

        val recyclerView: RecyclerView = findViewById(R.id.calendarRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 7)
        recyclerView.adapter = adapter

    }
}
