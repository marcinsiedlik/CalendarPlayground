package com.example.calendar.feature.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calendar.data.repository.EventRepository
import com.example.calendar.feature.calendar.state.CalendarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.time.LocalTime
import javax.inject.Inject
import kotlin.time.Duration.Companion.minutes

@HiltViewModel
class CalendarViewModel @Inject constructor(
  private val eventRepository: EventRepository,
) : ViewModel() {

  private val state = MutableStateFlow(CalendarState.initial())
  val stateFlow = state.asStateFlow()

  init {
    startTimeUpdate()
    eventRepository.events.onEach { events -> state.update { it.copy(events = events) } }
      .launchIn(viewModelScope)
  }

  private fun startTimeUpdate() = viewModelScope.launch {
    while (isActive) {
      state.update { it.copy(currentTime = LocalTime.now()) }
      delay(1.minutes)
    }
  }
}