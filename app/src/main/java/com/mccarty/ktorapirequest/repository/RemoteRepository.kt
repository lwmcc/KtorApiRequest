package com.mccarty.ktorapirequest.repository

import com.mccarty.ktorapirequest.model.WeatherResponseItem
import kotlinx.coroutines.flow.Flow

interface RemoteRepository {
    suspend fun fetchWeather(): Flow<WeatherResponseItem>
}