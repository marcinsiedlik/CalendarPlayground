package com.example.calendar.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.calendar.core.database.converter.LocalTimeConverter
import com.example.calendar.data.dao.EventDao
import com.example.calendar.data.model.EventEntity

@Database(
  entities = [
    EventEntity::class,
  ],
  version = 1,
  exportSchema = false,
)
@TypeConverters(LocalTimeConverter::class)
abstract class AppDatabase : RoomDatabase() {

  abstract fun eventDao(): EventDao
}