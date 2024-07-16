package com.marlonncarvalhosa.climafcil.data.remote.model.mapper

import com.marlonncarvalhosa.climafcil.data.remote.model.response.AstroResponse
import com.marlonncarvalhosa.climafcil.data.remote.model.response.ConditionResponse
import com.marlonncarvalhosa.climafcil.data.remote.model.response.CurrentResponse
import com.marlonncarvalhosa.climafcil.data.remote.model.response.DayResponse
import com.marlonncarvalhosa.climafcil.data.remote.model.response.ForecastObjectResponse
import com.marlonncarvalhosa.climafcil.data.remote.model.response.ForecastdayResponse
import com.marlonncarvalhosa.climafcil.data.remote.model.response.HourResponse
import com.marlonncarvalhosa.climafcil.data.remote.model.response.LocationResponse
import com.marlonncarvalhosa.climafcil.data.remote.model.response.WeatherResponse
import com.marlonncarvalhosa.climafcil.domain.model.Astro
import com.marlonncarvalhosa.climafcil.domain.model.Condition
import com.marlonncarvalhosa.climafcil.domain.model.Current
import com.marlonncarvalhosa.climafcil.domain.model.Day
import com.marlonncarvalhosa.climafcil.domain.model.ForecastObject
import com.marlonncarvalhosa.climafcil.domain.model.Forecastday
import com.marlonncarvalhosa.climafcil.domain.model.Hour
import com.marlonncarvalhosa.climafcil.domain.model.Location
import com.marlonncarvalhosa.climafcil.domain.model.Weather

object WeatherMapper {
    fun mapToDomain(weatherResponse: WeatherResponse): Weather {
        return Weather(
            location = mapLocation(weatherResponse.location),
            current = mapCurrent(weatherResponse.current),
            forecast = mapForecastObject(weatherResponse.forecast)
        )
    }

    private fun mapLocation(response: LocationResponse): Location {
        return Location(
            name = response.name,
            region = response.region,
            country = response.country,
            lat = response.lat,
            lon = response.lon,
            tz_id = response.tz_id,
            localtime = response.localtime,
            localtime_epoch = response.localtimeEpoch
        )
    }

    private fun mapCurrent(response: CurrentResponse): Current {
        return Current(
            last_updated_epoch = response.last_updated_epoch,
            last_updated = response.last_updated,
            temp_c = response.temp_c,
            temp_f = response.temp_f,
            is_day = response.is_day,
            condition = mapCondition(response.condition),
            wind_kph = response.wind_kph,
            wind_mph = response.wind_mph,
            wind_degree = response.wind_degree,
            wind_dir = response.wind_dir,
            pressure_mb = response.pressure_mb,
            pressure_in = response.pressure_in,
            precip_mm = response.precip_mm,
            precip_in = response.precip_in,
            humidity = response.humidity,
            cloud = response.cloud,
            feelslike_c = response.feelslike_c,
            feelslike_f = response.feelslike_f,
            windchill_c = response.windchill_c,
            windchill_f = response.windchill_f,
            heatindex_c = response.heatindex_c,
            heatindex_f = response.heatindex_f,
            dewpoint_c = response.dewpoint_c,
            dewpoint_f = response.dewpoint_f,
            vis_km = response.vis_km,
            vis_miles = response.vis_miles,
            uv = response.uv,
            gust_mph = response.gust_mph,
            gust_kph = response.gust_kph
        )
    }

    private fun mapForecastObject(response: ForecastObjectResponse): ForecastObject {
        return ForecastObject(
            forecastday = response.forecastday.map { mapForecastday(it) }
        )
    }

    private fun mapCondition(response: ConditionResponse): Condition {
        return Condition(
            code = response.code,
            icon = response.icon,
            text = response.text
        )
    }

    private fun mapForecastday(response: ForecastdayResponse): Forecastday {
        return Forecastday(
            astro = mapAstro(response.astro),
            date = response.date,
            date_epoch = response.dateEpoch,
            day = mapDay(response.day),
            hour = response.hour.map { mapHour(it) }
        )
    }

    private fun mapDay(response: DayResponse): Day {
        return Day(
            avghumidity = response.avghumidity,
            avgtemp_c = response.avgtempC,
            avgtemp_f = response.avgtempF,
            avgvis_km = response.avgvisKm,
            avgvis_miles = response.avgvisMiles,
            condition = mapCondition(response.condition),
            daily_chance_of_rain = response.dailyChanceOfRain,
            daily_chance_of_snow = response.dailyChanceOfSnow,
            daily_will_it_rain = response.dailyWillItRain,
            daily_will_it_snow = response.dailyWillItSnow,
            maxtemp_c = response.maxtempC,
            maxtemp_f = response.maxtempF,
            maxwind_kph = response.maxwindKph,
            maxwind_mph = response.maxwindMph,
            mintemp_c = response.mintempC,
            mintemp_f = response.mintempF,
            totalprecip_in = response.totalprecipIn,
            totalprecip_mm = response.totalprecipMm,
            totalsnow_cm = response.totalsnowCm,
            uv = response.uv
        )
    }

    private fun mapAstro(response: AstroResponse): Astro {
        return Astro(
            is_moon_up = response.is_moon_up,
            is_sun_up = response.is_sun_up,
            moon_illumination = response.moon_illumination,
            moon_phase = response.moon_phase,
            moonrise = response.moonrise,
            moonset = response.moonset,
            sunrise = response.sunrise,
            sunset = response.sunset
        )
    }

    private fun mapHour(response: HourResponse): Hour {
        return Hour(
            chance_of_rain = response.chance_of_rain,
            chance_of_snow = response.chance_of_snow,
            cloud = response.cloud,
            condition = mapCondition(response.condition),
            dewpoint_c = response.dewpoint_c,
            dewpoint_f = response.dewpoint_f,
            feelslike_c = response.feelslike_c,
            feelslike_f = response.feelslike_f,
            gust_kph = response.gust_kph,
            gust_mph = response.gust_mph,
            heatindex_c = response.heatindex_c,
            heatindex_f = response.heatindex_f,
            humidity = response.humidity,
            is_day = response.is_day,
            precip_in = response.precip_in,
            precip_mm = response.precip_mm,
            pressure_in = response.pressure_in,
            pressure_mb = response.pressure_mb,
            snow_cm = response.snow_cm,
            temp_c = response.temp_c,
            temp_f = response.temp_f,
            time = response.time,
            time_epoch = response.time_epoch,
            uv = response.uv,
            vis_km = response.vis_km,
            vis_miles = response.vis_miles,
            will_it_rain = response.will_it_rain,
            will_it_snow = response.will_it_snow,
            wind_degree = response.wind_degree,
            wind_dir = response.wind_dir,
            wind_kph = response.wind_kph,
            wind_mph = response.wind_mph,
            windchill_c = response.windchill_c,
            windchill_f = response.windchill_f
        )
    }
}