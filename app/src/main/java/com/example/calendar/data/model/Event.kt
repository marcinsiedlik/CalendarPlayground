package com.example.calendar.data.model

import java.time.Duration
import java.time.LocalTime

data class Event(
  val id: Long,
  val title: String,
  val description: String,
  val start: LocalTime,
  val end: LocalTime,
  val duration: Duration,
)