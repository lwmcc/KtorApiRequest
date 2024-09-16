package com.mccarty.ktorapirequest.usecase

import com.mccarty.ktorapirequest.model.WeatherResponseItem
import com.mccarty.ktorapirequest.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchWeatherUseCase @Inject constructor(private val remoteRepository: RemoteRepository): FetchWeather {
    override suspend fun fetchWeather(): Flow<WeatherResponseItem> {
        return remoteRepository.fetchWeather()
    }
}