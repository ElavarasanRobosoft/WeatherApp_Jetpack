package com.robosoft.weatherappjetpack.presentation.home

import com.robosoft.weatherappjetpack.domain.model.WeatherData

data class HomeScreenState(
    val isLoading: Boolean = false,
    val weatherData: WeatherData? = null,
    val error: String = ""
)
