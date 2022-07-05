package com.example.calendar.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val ColorPalette = lightColors(
  primary = LightBlue500,
  primaryVariant = LightBlue700,
  secondary = Orange500,
  secondaryVariant = Orange700,
)

@Composable
fun CalendarPlaygroundTheme(content: @Composable () -> Unit) {

  MaterialTheme(
    colors = ColorPalette,
    typography = Typography,
    shapes = Shapes,
    content = content
  )
}