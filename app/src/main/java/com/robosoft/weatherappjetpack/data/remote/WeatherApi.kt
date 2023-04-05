package com.robosoft.weatherappjetpack.data.remote

import com.robosoft.weatherappjetpack.data.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherApi {

    @GET("/data/2.5/weather?q={place}&appid=c1ce11af5f5e6b87d93ee0f41f03fc9b")
    suspend fun getWeatherData(@Path("place") place: String): WeatherDto

}