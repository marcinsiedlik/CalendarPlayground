package com.example.calendar.feature.event.create.state

import androidx.annotation.StringRes
import java.time.LocalTime

data class CreateEventState(
  val isLoading: Boolean,
  val name: String,
  @StringRes val nameErrorMessage: Int?,
  val description: String,
  val start: LocalTime,
  val end: LocalTime,
  val eventAdded: Boolean,
) {

  companion object {
    fun initial(time: LocalTime = LocalTime.now().let { LocalTime.of(it.hour, it.minute) }) = CreateEventState(
      isLoading = false,
      name = "",
      nameErrorMessage = null,
      description = "",
      start = time,
      end = time.plusHours(1),
      eventAdded = false,
    )
  }
}