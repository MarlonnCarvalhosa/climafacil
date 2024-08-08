package com.marlonncarvalhosa.climafcil.domain.repository

import com.marlonncarvalhosa.climafcil.domain.model.WeatherMain

interface WeatherRepository {
    suspend fun getWeather(apiKey: String, city: String): WeatherMain
}