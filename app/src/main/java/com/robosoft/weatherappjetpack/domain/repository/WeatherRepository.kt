package com.robosoft.weatherappjetpack.domain.repository

import com.robosoft.weatherappjetpack.data.remote.dto.WeatherDto

interface WeatherRepository {

    suspend fun getWeatherData(place: String): WeatherDto

}