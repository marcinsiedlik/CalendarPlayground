package com.example.calendar.core.di.bind

import com.example.calendar.data.repository.EventRepository
import com.example.calendar.data.repository.EventRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindModule {

  @Binds
  abstract fun bindEventRepository(eventRepositoryImpl: EventRepositoryImpl): EventRepository
}