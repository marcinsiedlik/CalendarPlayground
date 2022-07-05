package com.example.calendar.feature.calendar.layout.timeline

import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.calendar.data.model.Event
import com.example.calendar.feature.calendar.layout.EventItem
import java.time.LocalTime

@Composable
fun CalendarTimeline(
  modifier: Modifier = Modifier,
  hourRows: Int = 24,
  currentTime: LocalTime,
  events: List<Event>,
) {
  var itemHeight by remember { mutableStateOf(100.dp) }
  val scrollState = rememberScrollState()

  val transformState = rememberTimelineTransformableState(itemCount = hourRows) { rowHeight, calendarSizeChange ->
    itemHeight = rowHeight
    scrollState.dispatchRawDelta(calendarSizeChange)
  }

  Row(
    modifier = modifier
      .verticalScroll(scrollState)
      .transformable(transformState),
  ) {

    HourHeader(
      itemHeight = itemHeight,
      hourRows = hourRows,
    )

    Box {
      Column {
        repeat(hourRows) {
          HourRow(
            modifier = Modifier.height(itemHeight),
          )
        }
      }

      for (event in events) {
        EventItem(
          event = event,
          itemHeight = itemHeight,
        )
      }

      TimePointer(
        time = currentTime,
        itemHeight = itemHeight,
      )
    }
  }
}
