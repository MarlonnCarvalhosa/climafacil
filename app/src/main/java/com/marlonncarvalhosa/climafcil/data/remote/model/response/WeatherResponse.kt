package com.marlonncarvalhosa.climafcil.data.remote.model.response

data class WeatherResponse(
    val location: LocationResponse,
    val current: CurrentResponse,
    val forecast: ForecastObjectResponse
)