package com.marlonncarvalhosa.climafcil.data.remote.model.response

data class WeatherResponse(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)