package com.mccarty.ktorapirequest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mccarty.ktorapirequest.usecase.FetchWeather
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val fetchWeather: FetchWeather) : ViewModel() {

    init {
        viewModelScope.launch {
            fetchWeather.fetchWeather().collect {
                println("MainViewModel ***** ${it.toString()}")
            }
        }
    }
}