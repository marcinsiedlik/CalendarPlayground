package com.example.calendar.data.model

import java.time.LocalTime

data class CreateEventDto(
  val title: String,
  val description: String,
  val start: LocalTime,
  val end: LocalTime,
)