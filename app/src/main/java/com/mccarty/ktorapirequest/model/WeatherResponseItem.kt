package com.mccarty.ktorapirequest.model

import WeatherItem

data class WeatherResponseItem(
    val name: String,
    val sunrise: Long,
    val sunset: Long,
    val weatherItems: List<WeatherItem>,
)
