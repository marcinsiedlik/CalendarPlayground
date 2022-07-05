package com.example.calendar.feature.event.create.layout

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.calendar.R

@Composable
fun CreateEventNameField(
  value: String,
  onValueChange: (String) -> Unit,
  @StringRes errorMessage: Int? = null,
) {
  OutlinedTextField(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 8.dp),
    value = value,
    onValueChange = onValueChange,
    label = { Text(text = stringResource(id = R.string.name)) },
    singleLine = true,
    isError = errorMessage != null,
    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
  )
  if (errorMessage != null) {
    Text(
      modifier = Modifier.padding(start = 20.dp),
      text = stringResource(id = errorMessage),
      color = MaterialTheme.colors.error,
      style = MaterialTheme.typography.caption,
    )
  }
}

@Composable
fun CreateEventDescriptionField(
  value: String,
  onValueChange: (String) -> Unit,
) {
  val focusManager = LocalFocusManager.current

  OutlinedTextField(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp),
    value = value,
    onValueChange = onValueChange,
    label = { Text(text = stringResource(id = R.string.description)) },
    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
    keyboardActions = KeyboardActions { focusManager.clearFocus() }
  )
}