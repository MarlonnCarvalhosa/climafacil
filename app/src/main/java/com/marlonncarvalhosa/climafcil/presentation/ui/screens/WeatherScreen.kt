package com.marlonncarvalhosa.climafcil.presentation.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.marlonncarvalhosa.climafcil.presentation.ui.components.ErrorComponent
import com.marlonncarvalhosa.climafcil.presentation.ui.components.LoadingComponent
import com.marlonncarvalhosa.climafcil.presentation.ui.components.WeatherComponent
import com.marlonncarvalhosa.climafcil.presentation.ui.theme.WeatherState
import com.marlonncarvalhosa.climafcil.presentation.viewmodel.WeatherViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    viewModel: WeatherViewModel = koinViewModel()
) {
    val state by viewModel.weatherState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchWeather("0e524e630d94401fa8d142454240807", "Itaocara")
    }

    when (state) {
        is WeatherState.Loading -> LoadingComponent(modifier)
        is WeatherState.Success -> WeatherComponent(weather = (state as WeatherState.Success).weather, modifier)
        is WeatherState.Error -> ErrorComponent(exception = (state as WeatherState.Error).exception, modifier)
    }
}