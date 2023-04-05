package com.robosoft.weatherappjetpack.data.repository

import com.robosoft.weatherappjetpack.data.remote.WeatherApi
import com.robosoft.weatherappjetpack.data.remote.dto.WeatherDto
import com.robosoft.weatherappjetpack.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api:WeatherApi
): WeatherRepository {
    override suspend fun getWeatherData(place: String): WeatherDto {
        return api.getWeatherData(place)
    }

}