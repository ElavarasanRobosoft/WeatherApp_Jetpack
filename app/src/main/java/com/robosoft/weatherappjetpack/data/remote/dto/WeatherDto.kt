package com.robosoft.weatherappjetpack.data.remote.dto

data class WeatherDto(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)

fun WeatherDto.toWeatherData(): com.robosoft.weatherappjetpack.domain.model.WeatherData {
    return com.robosoft.weatherappjetpack.domain.model.WeatherData(
        temp = main.temp,
        description = weather[0],
        temp_max = main.temp_max,
        temp_min = main.temp_min,
        sea_level = main.sea_level,
        humidity = main.humidity
    )
}