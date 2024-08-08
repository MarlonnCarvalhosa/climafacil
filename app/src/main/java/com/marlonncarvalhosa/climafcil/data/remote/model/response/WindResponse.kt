package com.marlonncarvalhosa.climafcil.data.remote.model.response

data class WindResponse(
    val deg: Int,
    val gust: Double,
    val speed: Double
)