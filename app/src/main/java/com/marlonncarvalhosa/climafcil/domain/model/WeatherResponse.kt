package com.marlonncarvalhosa.climafcil.domain.model

data class WeatherResponse(
    val location: Location,
    val current: Current,
    val forecast: List<Forecastday>
)