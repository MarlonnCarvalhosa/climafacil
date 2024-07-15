package com.marlonncarvalhosa.climafcil.domain.model

data class Forecastday(
    val date: String,
    val dateEpoch: Long,
    val day: Day,
    val astro: Astro,
    val hour: List<Hour>
)