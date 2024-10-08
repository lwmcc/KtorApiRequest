package com.mccarty.ktorapirequest.api

import WeatherResponse
import io.ktor.http.URLBuilder
import kotlinx.coroutines.flow.Flow

interface Weather {
    fun fetchWeather(urlBuilder: URLBuilder): Flow<WeatherResponse>
}