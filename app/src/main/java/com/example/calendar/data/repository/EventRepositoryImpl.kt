package com.example.calendar.data.repository

import com.example.calendar.core.di.annotation.HiltDispatchers
import com.example.calendar.data.dao.EventDao
import com.example.calendar.data.mapper.EventMapper
import com.example.calendar.data.model.CreateEventDto
import com.example.calendar.data.model.Event
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventRepositoryImpl @Inject constructor(
  private val eventDao: EventDao,
  private val eventMapper: EventMapper,
  @HiltDispatchers.IO private val coroutineDispatcher: CoroutineDispatcher,
) : EventRepository {

  override val events: Flow<List<Event>> = eventDao.getEventsFlow()
    .map { it.map(eventMapper::mapToModel) }

  override suspend fun getEvent(eventId: Long) = withContext(coroutineDispatcher) {
    val entity = eventDao.getById(eventId)
    return@withContext eventMapper.mapToModel(entity)
  }

  override suspend fun addEvent(event: CreateEventDto) = withContext(coroutineDispatcher) {
    val entity = eventMapper.mapToEntity(event)
    eventDao.insert(entity)
  }
}