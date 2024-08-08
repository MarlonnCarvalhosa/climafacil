package com.marlonncarvalhosa.climafcil.presentation.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.marlonncarvalhosa.climafcil.presentation.ui.components.ErrorComponent
import com.marlonncarvalhosa.climafcil.presentation.ui.components.LoadingComponent
import com.marlonncarvalhosa.climafcil.presentation.ui.components.WeatherComponent
import com.marlonncarvalhosa.climafcil.presentation.ui.state.WeatherState
import com.marlonncarvalhosa.climafcil.presentation.viewmodel.WeatherViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    viewModel: WeatherViewModel = koinViewModel()
) {
    val state by viewModel.weatherState.collectAsState()

    LaunchedEffect(Unit) {
        //viewModel.fetchWeather("0e524e630d94401fa8d142454240807", "Itaocara")
        viewModel.fetchWeather("5527ed0547b65719428c40aa5892e8f6", "Itaocara")
    }

    when (state) {
        is WeatherState.Loading -> LoadingComponent(modifier)
        is WeatherState.Success -> WeatherComponent((state as WeatherState.Success).weather)
        is WeatherState.Error -> ErrorComponent(exception = (state as WeatherState.Error).exception, modifier)
    }
}