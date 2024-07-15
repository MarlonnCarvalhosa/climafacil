package com.marlonncarvalhosa.climafcil.domain.model

data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val tzId: String,
    val localtimeEpoch: Long,
    val localtime: String
)