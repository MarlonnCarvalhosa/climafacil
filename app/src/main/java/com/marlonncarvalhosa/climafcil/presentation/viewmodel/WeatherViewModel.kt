package com.marlonncarvalhosa.climafcil.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.marlonncarvalhosa.climafcil.domain.usecase.GetWeatherUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.viewModelScope
import com.marlonncarvalhosa.climafcil.domain.model.Weather
import com.marlonncarvalhosa.climafcil.presentation.ui.theme.WeatherState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _weatherState = MutableStateFlow<WeatherState>(WeatherState.Loading)
    val weatherState: StateFlow<WeatherState> get() = _weatherState

    fun fetchWeather(apiKey: String, city: String) {
        viewModelScope.launch {
            _weatherState.value = WeatherState.Loading
            getWeatherUseCase(apiKey, city).collect { result ->
                result.fold(
                    onSuccess = { weather -> _weatherState.value = WeatherState.Success(weather) },
                    onFailure = { exception -> _weatherState.value = WeatherState.Error(exception) }
                )
            }
        }
    }
}