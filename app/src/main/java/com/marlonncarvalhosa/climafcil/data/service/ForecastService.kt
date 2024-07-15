package com.marlonncarvalhosa.climafcil.data.service

import com.marlonncarvalhosa.climafcil.domain.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastService {

    @GET("/v1/current.json")
    suspend fun getForecast(
        @Query("key") apikey : String,
        @Query("q") city : String
    ) : Response<WeatherResponse>

}