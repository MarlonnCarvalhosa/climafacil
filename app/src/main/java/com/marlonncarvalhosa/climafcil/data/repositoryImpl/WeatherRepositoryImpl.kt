package com.marlonncarvalhosa.climafcil.data.repositoryImpl

import com.marlonncarvalhosa.climafcil.data.remote.api.ForecastService
import com.marlonncarvalhosa.climafcil.data.remote.model.mapper.WeatherMapper
import com.marlonncarvalhosa.climafcil.domain.model.WeatherMain
import com.marlonncarvalhosa.climafcil.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val forecastService: ForecastService
) : WeatherRepository {
    override suspend fun getWeather(apiKey: String, city: String): WeatherMain {
        val response = forecastService.getForecast(apiKey, city)
        if (response.isSuccessful) {
            response.body()?.let {
                return WeatherMapper.mapToDomain(it)
            }
        }
        throw Exception("Failed to fetch weather data")
    }
}