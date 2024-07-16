package com.marlonncarvalhosa.climafcil.data.remote.model.response

data class ForecastdayResponse(
    val date: String,
    val dateEpoch: Long,
    val day: DayResponse,
    val astro: AstroResponse,
    val hour: List<HourResponse>
)