package com.example.calendar.data.repository

import com.example.calendar.data.model.CreateEventDto
import com.example.calendar.data.model.Event
import kotlinx.coroutines.flow.Flow

interface EventRepository {

  val events: Flow<List<Event>>

  suspend fun getEvent(eventId: Long): Event

  suspend fun addEvent(event: CreateEventDto)
}