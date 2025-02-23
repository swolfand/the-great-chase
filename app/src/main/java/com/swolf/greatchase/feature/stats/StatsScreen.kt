package com.swolf.greatchase.feature.stats

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swolf.greatchase.ui.theme.BackgroundBlack

@Composable
fun StatsScreen(modifier: Modifier = Modifier) {
  Column(modifier = Modifier.fillMaxSize().then(modifier).background(color = BackgroundBlack)) {}
}

@Composable
fun StatsBlock(modifier: Modifier = Modifier) {
  Box(modifier = Modifier.clip(RoundedCornerShape(8.dp)).then(modifier)) {

    Text()

  }
}

@Preview
@Composable
private fun PreviewStatsScreen() {
  StatsScreen()
}
