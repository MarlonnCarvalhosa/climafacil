package com.marlonncarvalhosa.climafcil.data.remote.model.response

data class LocationResponse(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val tz_id: String,
    val localtimeEpoch: Long,
    val localtime: String
)