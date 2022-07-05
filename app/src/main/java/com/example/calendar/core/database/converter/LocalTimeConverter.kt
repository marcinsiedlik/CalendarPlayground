package com.example.calendar.core.database.converter

import androidx.room.TypeConverter
import java.time.LocalTime

class LocalTimeConverter {

  @TypeConverter
  fun fromLocalTime(localTime: LocalTime): String {
    return localTime.toString()
  }

  @TypeConverter
  fun toLocalTime(string: String): LocalTime {
    return LocalTime.parse(string)
  }
}