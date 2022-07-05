package com.example.calendar.data.mapper

import com.example.calendar.data.model.CreateEventDto
import com.example.calendar.data.model.Event
import com.example.calendar.data.model.EventEntity
import java.time.Duration
import javax.inject.Inject

class EventMapper @Inject constructor() {

  fun mapToModel(entity: EventEntity) = Event(
    id = entity.id,
    title = entity.title,
    description = entity.description,
    start = entity.start,
    end = entity.end,
    duration = Duration.between(entity.start, entity.end),
  )

  fun mapToEntity(dto: CreateEventDto) = EventEntity(
    id = 0,
    title = dto.title,
    description = dto.description,
    start = dto.start,
    end = dto.end,
  )
}