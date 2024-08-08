package com.marlonncarvalhosa.climafcil.presentation.ui.state

import com.marlonncarvalhosa.climafcil.domain.model.WeatherMain

sealed class WeatherState {
    data object Loading : WeatherState()
    data class Success(val weather: WeatherMain) : WeatherState()
    data class Error(val exception: Throwable) : WeatherState()
}