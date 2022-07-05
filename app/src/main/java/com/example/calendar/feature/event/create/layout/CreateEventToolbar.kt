package com.example.calendar.feature.event.create.layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.calendar.R

@Composable
fun CreateEventToolbar(
  onCreateClick: () -> Unit,
  onCancelClick: () -> Unit,
) {
  Row(
    modifier = Modifier.height(56.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Icon(
      modifier = Modifier
        .size(56.dp)
        .clickable(onClick = onCancelClick)
        .padding(16.dp),
      imageVector = Icons.Filled.Close,
      contentDescription = stringResource(id = R.string.cancel),
    )
    Text(
      modifier = Modifier.weight(1f),
      text = stringResource(id = R.string.create_event),
      textAlign = TextAlign.Center,
    )
    Icon(
      modifier = Modifier
        .size(56.dp)
        .clickable(onClick = onCreateClick)
        .padding(16.dp),
      imageVector = Icons.Filled.Check,
      contentDescription = stringResource(id = R.string.create),
    )
  }
}