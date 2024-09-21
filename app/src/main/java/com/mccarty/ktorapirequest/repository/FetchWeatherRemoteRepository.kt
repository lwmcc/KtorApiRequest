package com.mccarty.ktorapirequest.repository

import ApiKeys.WEATHER_API_KEY
import com.mccarty.ktorapirequest.api.ApiConstants
import com.mccarty.ktorapirequest.api.BuildApiUrl
import com.mccarty.ktorapirequest.api.Weather
import com.mccarty.ktorapirequest.model.UrlParam
import com.mccarty.ktorapirequest.model.WeatherResponseItem
import io.ktor.http.URLProtocol
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FetchWeatherRemoteRepository @Inject constructor(private val weather: Weather) :
    RemoteRepository {
    override fun fetchWeather(): Flow<WeatherResponseItem> {
        return weather.fetchWeather(
            BuildApiUrl.forecastUrl(
                protocol = URLProtocol.HTTPS,
                host = ApiConstants.WEATHER_HOST,
                path = ApiConstants.FORECAST_PATH,
                UrlParam(
                    name = ApiConstants.APPID_PARAM,
                    value = WEATHER_API_KEY
                ),
                UrlParam(name = ApiConstants.LAT_PARAM, value = "33.552"),
                UrlParam(name = ApiConstants.LON_PARAM, value = "-111.11111"),
            )
        ).map {
            WeatherResponseItem(
                name = it.city.name,
                sunrise = it.city.sunrise,
                sunset = it.city.sunset,
                weatherItems = it.list,
            )
        }
    }
}