package com.example.calendar.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.calendar.ui.navigation.AppNavHost
import com.example.calendar.ui.theme.CalendarPlaygroundTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setComposeContent()
  }

  private fun setComposeContent() = setContent {
    CalendarPlaygroundTheme {
      AppNavHost()
    }
  }
}
