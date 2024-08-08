package com.marlonncarvalhosa.climafcil.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marlonncarvalhosa.climafcil.R
import com.marlonncarvalhosa.climafcil.domain.model.WeatherMain
import com.marlonncarvalhosa.climafcil.utils.beforeDot

@Composable
fun WeatherComponent(
    weatherState: WeatherMain
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.img),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            weatherState.let { weather ->
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = weather.name,
                        fontSize = 24.sp,
                        color = Color.White
                    )
                    Text(
                        text = "${weather.main.temp.beforeDot()}°",
                        fontSize = 48.sp,
                        color = Color.White
                    )
                    weather.weather.firstOrNull()?.description?.let {
                        Text(
                            text = it,
                            color = Color.White,
                            fontSize = 24.sp,
                            modifier = Modifier.padding(start = 8.dp),
                        )
                    }
                    Text(
                        text = "Máx.: ${weather.main.temp_max.beforeDot()}° Mín.: ${weather.main.temp_min.beforeDot()}°",
                        color = Color.White
                    )
                }
            }
        }
    }
}
