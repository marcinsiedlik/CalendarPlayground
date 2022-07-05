package com.example.calendar.core.extension

import java.time.LocalTime

val LocalTime.hourProgress: Float
  get() = minute / 60f