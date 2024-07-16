package com.marlonncarvalhosa.climafcil.domain.model

data class Forecastday(
    val astro: Astro,
    val date: String,
    val date_epoch: Long,
    val day: Day,
    val hour: List<Hour>
)