package com.example.calendar.feature.calendar.layout.timeline

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.calendar.core.extension.hourProgress
import com.example.calendar.ui.theme.Emperor
import java.time.LocalTime

@Composable
fun TimePointer(
  time: LocalTime,
  itemHeight: Dp,
  modifier: Modifier = Modifier,
  color: Color = Emperor,
) {

  Canvas(
    modifier = modifier
      .fillMaxWidth()
      .offset {
        IntOffset(
          x = 0,
          y = (itemHeight * (time.hour + time.hourProgress)).roundToPx(),
        )
      }
  ) {
    drawCircle(
      color = color,
      radius = 6.dp.toPx(),
      center = Offset.Zero,
    )
    drawLine(
      color = color,
      start = Offset.Zero,
      end = Offset(size.width, 0f),
      strokeWidth = 2.dp.toPx()
    )
  }
}