package com.mccarty.ktorapirequest.usecase

import com.mccarty.ktorapirequest.model.WeatherResponseItem
import kotlinx.coroutines.flow.Flow

interface FetchWeather {
    fun fetchWeather(): Flow<WeatherResponseItem>
}