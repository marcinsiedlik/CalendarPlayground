package com.example.calendar.feature.event.create

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calendar.R
import com.example.calendar.data.model.CreateEventDto
import com.example.calendar.data.repository.EventRepository
import com.example.calendar.feature.event.create.state.CreateEventState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalTime
import javax.inject.Inject

@HiltViewModel
class CreateEventViewModel @Inject constructor(
  private val eventRepository: EventRepository,
) : ViewModel() {

  private val state = MutableStateFlow(CreateEventState.initial())
  val stateFlow = state.asStateFlow()

  fun onNameChanged(name: String) = state.update {
    it.copy(name = name)
  }

  fun onDescriptionChanged(description: String) = state.update {
    it.copy(description = description)
  }

  fun onStartDateSelected(hour: Int, minute: Int) {
    state.update { it.copy(start = LocalTime.of(hour, minute)) }
  }

  fun onEndDateSelected(hour: Int, minute: Int) {
    state.update { it.copy(end = LocalTime.of(hour, minute)) }
  }

  fun onCreateClicked() {
    val errorMessage = getNameErrorMessage(state.value.name)
    if (errorMessage != null) {
      state.update { it.copy(nameErrorMessage = errorMessage) }
      return
    }
    viewModelScope.launch {
      val state = state.value
      val event = CreateEventDto(
        title = state.name,
        description = state.description,
        start = state.start,
        end = state.end,
      )
      eventRepository.addEvent(event)
      this@CreateEventViewModel.state.update { it.copy(eventAdded = true) }
    }
  }

  @StringRes
  private fun getNameErrorMessage(text: String): Int? = when {
    text.isBlank() -> R.string.field_required
    text.length < 4 -> R.string.name_too_short
    else -> null
  }
}