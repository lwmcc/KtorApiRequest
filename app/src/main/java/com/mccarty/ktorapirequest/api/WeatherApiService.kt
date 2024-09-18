package com.mccarty.ktorapirequest.api

import WeatherResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLBuilder
import io.ktor.http.takeFrom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherApiService @Inject constructor(private val httpClient: HttpClient) : Weather {

    override suspend fun fetchWeather(urlBuilder: URLBuilder): Flow<WeatherResponse> =
        flow {
            httpClient.use {
                emit(it.get {
                    url { takeFrom(urlBuilder) }
                }.body<WeatherResponse>())
            }
        }
}