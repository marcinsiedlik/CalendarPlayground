package com.example.calendar.feature.event.create

import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.calendar.feature.event.create.layout.CreateEventDescriptionField
import com.example.calendar.feature.event.create.layout.CreateEventNameField
import com.example.calendar.feature.event.create.layout.CreateEventToolbar
import com.example.calendar.feature.event.create.layout.TimeSelectorRow
import java.time.LocalTime

@Composable
fun CreateEventScreen(
  navController: NavController,
  viewModel: CreateEventViewModel = hiltViewModel(),
) {
  Scaffold(
    topBar = {
      CreateEventToolbar(
        onCancelClick = { navController.navigateUp() },
        onCreateClick = viewModel::onCreateClicked,
      )
    },
  ) { paddingValues ->
    val state by viewModel.stateFlow.collectAsState()
    val context = LocalContext.current

    if (state.eventAdded) {
      navController.navigateUp()
    }

    Column(modifier = Modifier.padding(paddingValues)) {
      CreateEventNameField(
        value = state.name,
        onValueChange = viewModel::onNameChanged,
        errorMessage = state.nameErrorMessage,
      )
      CreateEventDescriptionField(
        value = state.description,
        onValueChange = viewModel::onDescriptionChanged,
      )
      TimeSelectorRow(
        start = state.start,
        end = state.end,
        onStartClick = { showTimePickerDialog(context, viewModel::onStartDateSelected) },
        onEndClick = { showTimePickerDialog(context, viewModel::onEndDateSelected) },
      )
    }
  }
}

private fun showTimePickerDialog(
  context: Context,
  onTimeSelected: (hour: Int, minute: Int) -> Unit,
) {
  val listener = OnTimeSetListener { _, hour, minute ->
    onTimeSelected(hour, minute)
  }
  val current = LocalTime.now()
  TimePickerDialog(context, listener, current.hour, current.minute, true).show()
}
