package com.marlonncarvalhosa.climafcil.domain.usecase

import com.marlonncarvalhosa.climafcil.domain.model.WeatherMain
import com.marlonncarvalhosa.climafcil.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWeatherUseCase(private val weatherRepository: WeatherRepository) {
    operator fun invoke(apiKey: String, city: String): Flow<Result<WeatherMain>> = flow {
        try {
            val weather = weatherRepository.getWeather(apiKey, city)
            emit(Result.success(weather))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}