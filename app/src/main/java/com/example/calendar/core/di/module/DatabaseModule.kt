package com.example.calendar.core.di.module

import android.content.Context
import androidx.room.Room
import com.example.calendar.core.database.AppDatabase
import com.example.calendar.data.dao.EventDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

  @Singleton
  @Provides
  fun provideAppDatabase(@ApplicationContext context: Context) =
    Room.databaseBuilder(context, AppDatabase::class.java, "app-database")
      .fallbackToDestructiveMigration()
      .build()

  @Singleton
  @Provides
  fun provideEventDao(database: AppDatabase): EventDao = database.eventDao()
}