package com.marlonncarvalhosa.climafcil.data.remote.model.mapper

import com.marlonncarvalhosa.climafcil.data.remote.model.response.CloudsResponse
import com.marlonncarvalhosa.climafcil.data.remote.model.response.CoordResponse
import com.marlonncarvalhosa.climafcil.data.remote.model.response.MainResponse
import com.marlonncarvalhosa.climafcil.data.remote.model.response.SysResponse
import com.marlonncarvalhosa.climafcil.data.remote.model.response.WeatherMainResponse
import com.marlonncarvalhosa.climafcil.data.remote.model.response.WeatherResponse
import com.marlonncarvalhosa.climafcil.data.remote.model.response.WindResponse
import com.marlonncarvalhosa.climafcil.domain.model.Clouds
import com.marlonncarvalhosa.climafcil.domain.model.Coord
import com.marlonncarvalhosa.climafcil.domain.model.Main
import com.marlonncarvalhosa.climafcil.domain.model.Sys
import com.marlonncarvalhosa.climafcil.domain.model.Weather
import com.marlonncarvalhosa.climafcil.domain.model.WeatherMain
import com.marlonncarvalhosa.climafcil.domain.model.Wind


object WeatherMapper {
    fun mapToDomain(weatherResponse: WeatherMainResponse): WeatherMain {
        return WeatherMain(
            coord = mapCoord(weatherResponse.coord),
            weather = weatherResponse.weather.map { mapWeather(it) },
            base = weatherResponse.base,
            main = mapMain(weatherResponse.main),
            visibility = weatherResponse.visibility,
            wind = mapWind(weatherResponse.wind),
            clouds = mapClouds(weatherResponse.clouds),
            dt = weatherResponse.dt,
            sys = mapSys(weatherResponse.sys),
            timezone = weatherResponse.timezone,
            id = weatherResponse.id,
            name = weatherResponse.name,
            cod = weatherResponse.cod
        )
    }

    private fun mapCoord(response: CoordResponse): Coord {
        return Coord(
            lon = response.lon,
            lat = response.lat
        )
    }

    private fun mapWeather(response: WeatherResponse): Weather {
        return Weather(
            id = response.id,
            main = response.main,
            description = response.description,
            icon = response.icon
        )
    }

    private fun mapMain(response: MainResponse): Main {
        return Main(
            temp = response.temp,
            feels_like = response.feels_like,
            temp_min = response.temp_min,
            temp_max = response.temp_max,
            pressure = response.pressure,
            humidity = response.humidity,
            sea_level = response.sea_level,
            grnd_level = response.grnd_level
        )
    }

    private fun mapWind(response: WindResponse): Wind {
        return Wind(
            speed = response.speed,
            deg = response.deg,
            gust = response.gust
        )
    }

    private fun mapClouds(response: CloudsResponse): Clouds {
        return Clouds(
            all = response.all
        )
    }

    private fun mapSys(response: SysResponse): Sys {
        return Sys(
            country = response.country,
            sunrise = response.sunrise,
            sunset = response.sunset
        )
    }
}
