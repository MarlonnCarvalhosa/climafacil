package com.marlonncarvalhosa.climafcil.data.remote.api

import com.marlonncarvalhosa.climafcil.data.remote.model.response.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastService {

    @GET("forecast.json")
    suspend fun getForecast(
        @Query("key") apikey : String,
        @Query("q") city : String
    ) : Response<WeatherResponse>

}