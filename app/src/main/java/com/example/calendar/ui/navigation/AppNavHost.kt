package com.example.calendar.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calendar.feature.calendar.CalendarScreen
import com.example.calendar.feature.event.create.CreateEventScreen

@Composable
fun AppNavHost() {
  val navController = rememberNavController()

  NavHost(navController, startDestination = NavDestination.calendar) {
    composable(NavDestination.calendar) { CalendarScreen(navController) }
    composable(NavDestination.createEvent) { CreateEventScreen(navController) }
  }
}

object NavDestination {
  const val calendar = "calendar"
  const val createEvent = "create-event"
}