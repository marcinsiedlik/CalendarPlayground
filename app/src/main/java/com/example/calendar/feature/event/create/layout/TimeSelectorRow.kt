package com.example.calendar.feature.event.create.layout

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.calendar.R
import java.time.LocalTime

@Composable
fun TimeSelectorRow(
  start: LocalTime,
  end: LocalTime,
  onStartClick: () -> Unit,
  onEndClick: () -> Unit,
) {
  Row(
    modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp),
  ) {
    Spacer(modifier = Modifier.weight(1f))

    Button(onClick = onStartClick) {
      Icon(
        imageVector = Icons.Outlined.DateRange,
        contentDescription = null,
      )
      Spacer(modifier = Modifier.width(4.dp))
      Text(text = stringResource(id = R.string.from_arg, start.toString()))
    }

    Spacer(modifier = Modifier.width(32.dp))

    Button(onClick = onEndClick) {
      Icon(
        imageVector = Icons.Filled.DateRange,
        contentDescription = null,
      )
      Spacer(modifier = Modifier.width(4.dp))
      Text(text = stringResource(id = R.string.to_arg, end.toString()))
    }

    Spacer(modifier = Modifier.weight(1f))
  }
}
