package com.example.calendar.feature.calendar.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calendar.core.extension.hourProgress
import com.example.calendar.data.model.Event
import com.example.calendar.ui.theme.LightBlue500

@Composable
fun EventItem(
  event: Event,
  itemHeight: Dp,
  modifier: Modifier = Modifier,
) {
  val height = remember(itemHeight) {
    itemHeight * (event.duration.toMinutes() / 60f)
  }

  Box(
    modifier = modifier
      .fillMaxWidth()
      .height(height)
      .padding(horizontal = 16.dp)
      .offset(0.dp, height * (event.start.hour + event.start.hourProgress))
      .clip(RoundedCornerShape(6.dp))
      .background(LightBlue500)
  ) {
    if (height < 60.dp) {
      Text(
        modifier = Modifier.padding(vertical = 2.dp, horizontal = 8.dp),
        text = event.title,
        color = Color.White,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
      )
    } else {
      Column(
        modifier = Modifier.padding(8.dp)
      ) {
        Text(
          text = event.title,
          color = Color.White,
          fontWeight = FontWeight.SemiBold,
          fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
          text = event.description,
          color = Color.White,
          fontSize = 14.sp,
          overflow = TextOverflow.Ellipsis,
        )
      }
    }
  }
}