package com.marlonncarvalhosa.climafcil.presentation.ui.theme

import com.marlonncarvalhosa.climafcil.domain.model.Weather

sealed class WeatherState {
    data object Loading : WeatherState()
    data class Success(val weather: Weather) : WeatherState()
    data class Error(val exception: Throwable) : WeatherState()
}