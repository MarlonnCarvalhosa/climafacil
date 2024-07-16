package com.marlonncarvalhosa.climafcil.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.marlonncarvalhosa.climafcil.domain.model.Weather

@Composable
fun WeatherComponent(weather: Weather, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        weather.location.name.let {
            Text(
                text = it,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Temperature: ${weather.current.temp_c}°C",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        AsyncImage(
            model = "https:${weather.current.condition.icon}",
            contentDescription = weather.current.condition.text,
            modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Condition: ${weather.current.condition.text}",
            fontSize = 20.sp
        )
    }
}