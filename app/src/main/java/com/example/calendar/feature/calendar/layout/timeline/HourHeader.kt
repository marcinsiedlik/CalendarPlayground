package com.example.calendar.feature.calendar.layout.timeline

import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HourHeader(
  itemHeight: Dp,
  hourRows: Int,
) {
  val density = LocalDensity.current

  val textPaint = remember {
    Paint().asFrameworkPaint().apply {
      isAntiAlias = true
      textSize = with(density) { 10.sp.toPx() }
      color = Color.Gray.toArgb()
      typeface = Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL)
    }
  }

  Canvas(
    modifier = Modifier
      .size(56.dp, itemHeight * hourRows)
  ) {
    val itemHeightPx = itemHeight.roundToPx().toFloat()

    drawLine(
      color = Color.LightGray,
      start = Offset(size.width, 0f),
      end = Offset(size.width, size.height)
    )

    repeat(hourRows) { index ->
      val rowIndex = index + 1
      drawContext.canvas.nativeCanvas.drawText(
        "%02d:00".format(rowIndex),
        4.dp.toPx(),
        itemHeightPx * rowIndex + 6,
        textPaint
      )
      drawLine(
        color = Color.LightGray,
        start = Offset(38.dp.toPx(), itemHeightPx * rowIndex),
        end = Offset(size.width, itemHeightPx * rowIndex),
      )
    }
  }
}