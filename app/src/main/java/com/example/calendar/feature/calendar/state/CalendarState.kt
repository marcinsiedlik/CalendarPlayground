package com.example.calendar.feature.calendar.state

import com.example.calendar.data.model.Event
import java.time.LocalTime

data class CalendarState(
  val events: List<Event>,
  val currentTime: LocalTime,
) {

  companion object {
    fun initial(time: LocalTime = LocalTime.now()) = CalendarState(
      events = listOf(),
      currentTime = time,
    )
  }
}