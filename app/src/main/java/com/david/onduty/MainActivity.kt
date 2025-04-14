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
        date = LocalDate.of(2025, 6, 2)

        initViews();
    }

    private fun initViews() {
        monthView = findViewById(R.id.monthYearTextView)
        monthView.text = date.format(DateTimeFormatter.ofPattern("MMMM yyyy"))

        val dataSet = getMonthDays()
        val adapter = CalendarAdapter(dataSet)

        calendarView = findViewById(R.id.calendarRecyclerView)
        calendarView.layoutManager = GridLayoutManager(this, 7)
        calendarView.adapter = adapter
    }

    private fun getMonthDays() : Array<Int> {
        val monthDays = mutableListOf<Int>()
        val firstDayOfMonth = date.minusDays(date.dayOfMonth.toLong() - 1)
        val lastDayOfMonth = date.plusDays((date.lengthOfMonth() - date.dayOfMonth).toLong())
        var day = firstDayOfMonth.minusDays(firstDayOfMonth.dayOfWeek.value.toLong() - 1)

        while (day != lastDayOfMonth.plusDays(1)) {
            println(day)
            monthDays.add(day.dayOfMonth)
            day = day.plusDays(1)
        }

        return monthDays.toTypedArray()
    }

}
