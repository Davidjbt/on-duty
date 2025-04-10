package com.david.onduty

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.david.onduty.ui.CalendarAdapter
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {

    private lateinit var calendarView: RecyclerView
    private lateinit var monthView: TextView
    private lateinit var date: LocalDate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        date = LocalDate.now()
        initViews();
    }

    private fun initViews() {
        monthView = findViewById(R.id.monthYearTextView)
        monthView.text = date.format(DateTimeFormatter.ofPattern("MMMM yyyy"))

        val dataSet = IntArray(42) {i -> i + 1}
        val adapter = CalendarAdapter(dataSet.toTypedArray())

        calendarView = findViewById(R.id.calendarRecyclerView)
        calendarView.layoutManager = GridLayoutManager(this, 7)
        calendarView.adapter = adapter
    }

}
