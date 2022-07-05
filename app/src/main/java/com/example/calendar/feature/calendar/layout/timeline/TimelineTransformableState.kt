package com.example.calendar.feature.calendar.layout.timeline

import androidx.compose.foundation.gestures.TransformableState
import androidx.compose.runtime.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun rememberTimelineTransformableState(
  initialHeight: Dp = 100.dp,
  heightRange: ClosedRange<Dp> = 30.dp..150.dp,
  itemCount: Int = 24,
  onTransformation: (rowHeight: Dp, calendarSizeChange: Float) -> Unit,
): TransformableState {
  var itemHeight by remember { mutableStateOf(initialHeight) }
  val lambdaState = rememberUpdatedState(onTransformation)

  return remember {
    TransformableState { zoom, _, _ ->
      if (zoom == 1f) {
        return@TransformableState
      }
      val newItemHeight = when {
        zoom > 1f -> itemHeight + zoom.dp
        else -> itemHeight - zoom.dp
      }.coerceIn(heightRange)

      // TODO change delta probably should be calculated as dp from density
      val overallSizeChange = when {
        newItemHeight == heightRange.start || newItemHeight == heightRange.endInclusive -> 0f
        zoom > 1f -> zoom * itemCount
        else -> (zoom * -1) * itemCount
      }
      itemHeight = newItemHeight
      lambdaState.value.invoke(newItemHeight, overallSizeChange)
    }
  }
}