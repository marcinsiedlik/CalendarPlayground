package com.example.calendar.feature.calendar

import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.calendar.R
import com.example.calendar.feature.calendar.layout.timeline.CalendarTimeline
import com.example.calendar.ui.navigation.NavDestination

@Composable
fun CalendarScreen(
  navController: NavController,
  viewModel: CalendarViewModel = hiltViewModel(),
) {
  val state by viewModel.stateFlow.collectAsState()

  Scaffold(
    floatingActionButton = {
      FloatingActionButton(
        onClick = { navController.navigate(NavDestination.createEvent) },
      ) {
        Icon(
          imageVector = Icons.Filled.Add,
          contentDescription = stringResource(id = R.string.create_event),
        )
      }
    },
  ) { padding ->
    CalendarTimeline(
      modifier = Modifier.padding(padding),
      currentTime = state.currentTime,
      events = state.events,
    )
  }
}