package com.marlonncarvalhosa.climafcil.domain.model


data class Weather(
    val current: Current,
    val forecast: ForecastObject,
    val location: Location
)