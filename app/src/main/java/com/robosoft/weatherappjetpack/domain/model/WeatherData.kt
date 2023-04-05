package com.robosoft.weatherappjetpack.domain.model

import com.robosoft.weatherappjetpack.data.remote.dto.Weather

data class WeatherData(
    val temp: Double,
    val description: Weather,
    val temp_max: Double,
    val temp_min: Double,
    val sea_level: Int,
    val humidity: Int
)
