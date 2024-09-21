package com.mccarty.ktorapirequest.repository

import com.mccarty.ktorapirequest.model.WeatherResponseItem
import kotlinx.coroutines.flow.Flow

interface RemoteRepository {
    fun fetchWeather(): Flow<WeatherResponseItem>
}