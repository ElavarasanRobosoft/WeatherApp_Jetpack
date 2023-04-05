package com.robosoft.weatherappjetpack.domain.usecase

import com.robosoft.weatherappjetpack.common.Resource
import com.robosoft.weatherappjetpack.data.remote.dto.toWeatherData
import com.robosoft.weatherappjetpack.domain.model.WeatherData
import com.robosoft.weatherappjetpack.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    operator fun invoke(place: String) = flow {
        try {
            emit(Resource.Loading<WeatherData>())
            val weather = repository.getWeatherData(place).toWeatherData()
            emit(Resource.Success<WeatherData>(weather))
        } catch (e: HttpException){
            emit(Resource.Error<WeatherData>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<WeatherData>("Couldn't reach server. Check your internet connection"))
        }
    }
}