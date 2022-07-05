package com.example.calendar.feature.calendar.layout.timeline

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

@Composable
fun HourRow(modifier: Modifier = Modifier) {

  Box(
    modifier = modifier
      .fillMaxSize()
      .clickable { }
      .drawBehind {
        drawLine(
          color = Color.LightGray,
          start = Offset(0f, size.height),
          end = Offset(size.width, size.height),
        )
      }
  ) {
    // Empty for now
  }
}