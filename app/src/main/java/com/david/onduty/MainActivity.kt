package com.david.onduty

import android.os.Bundle
import android.widget.Button
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
    private lateinit var previousMonthButton: Button
    private lateinit var nextMonthButton: Button

    private lateinit var adapter: CalendarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        date = LocalDate.now()

        initViews();
    }

    private fun initViews() {
        monthView = findViewById(R.id.monthYearTextView)
        monthView.text = date.format(DateTimeFormatter.ofPattern("MMMM yyyy"))

        val initialMonthDays = getMonthDays()
        adapter = CalendarAdapter(initialMonthDays)

        calendarView = findViewById(R.id.calendarRecyclerView)
        calendarView.layoutManager = GridLayoutManager(this, 7)
        calendarView.adapter = adapter

        previousMonthButton = findViewById(R.id.previousMonthButton)
        nextMonthButton = findViewById(R.id.nextMonthButton)

        previousMonthButton.setOnClickListener { previousMonth() }
        nextMonthButton.setOnClickListener { nextMonth() }
    }

    private fun getMonthDays() : Array<Int> {
        val monthDays = mutableListOf<Int>()
        val firstDayOfMonth = date.minusDays(date.dayOfMonth.toLong() - 1)
        val lastDayOfMonth = date.plusDays((date.lengthOfMonth() - date.dayOfMonth).toLong())
        var day = firstDayOfMonth.minusDays(firstDayOfMonth.dayOfWeek.value.toLong() - 1)

        while (!day.isAfter(lastDayOfMonth)) {
            monthDays.add(day.dayOfMonth)
            day = day.plusDays(1)
        }

        return monthDays.toTypedArray()
    }

    private fun previousMonth() {
        date = date.minusMonths(1)
        val monthDays = getMonthDays()

        monthView.text = date.format(DateTimeFormatter.ofPattern("MMMM yyyy"))
        adapter.updateMonthDays(monthDays)
    }

    private fun nextMonth() {
        date = date.plusMonths(1)
        val monthDays = getMonthDays()

        monthView.text = date.format(DateTimeFormatter.ofPattern("MMMM yyyy"))
        adapter.updateMonthDays(monthDays)
    }

}
