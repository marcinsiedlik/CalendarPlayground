package com.example.calendar.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalTime

@Entity(tableName = "events")
data class EventEntity(
  @PrimaryKey(autoGenerate = true)
  val id: Long,
  val title: String,
  val description: String,
  val start: LocalTime,
  val end: LocalTime,
)