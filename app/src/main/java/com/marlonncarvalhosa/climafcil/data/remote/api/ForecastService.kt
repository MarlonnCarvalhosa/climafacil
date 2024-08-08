package com.marlonncarvalhosa.climafcil.data.remote.api

import com.marlonncarvalhosa.climafcil.data.remote.model.response.WeatherMainResponse
import com.marlonncarvalhosa.climafcil.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastService {

    @GET("weather")
    suspend fun getForecast(
        @Query("appid") apikey : String,
        @Query("q") city : String,
        @Query("lang") lang : String = Constants.LANG,
        @Query("units") units  : String = "metric"
    ) : Response<WeatherMainResponse>

}