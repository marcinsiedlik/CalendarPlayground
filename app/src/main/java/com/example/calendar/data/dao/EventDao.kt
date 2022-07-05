package com.example.calendar.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.calendar.data.model.EventEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {

  @Query("SELECT * FROM events")
  fun getEventsFlow(): Flow<List<EventEntity>>

  @Query("SELECT * FROM events")
  suspend fun getAll(): List<EventEntity>

  @Query("SELECT * FROM events WHERE id == :eventId")
  suspend fun getById(eventId: Long): EventEntity

  @Insert
  suspend fun insert(eventEntity: EventEntity)

  @Delete
  fun delete(eventEntity: EventEntity)
}