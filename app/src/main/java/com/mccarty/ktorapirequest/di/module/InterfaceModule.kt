package com.mccarty.ktorapirequest.di.module

import com.mccarty.ktorapirequest.api.WeatherApiService
import com.mccarty.ktorapirequest.api.Weather
import com.mccarty.ktorapirequest.repository.FetchWeatherRemoteRepository
import com.mccarty.ktorapirequest.repository.RemoteRepository
import com.mccarty.ktorapirequest.usecase.FetchWeather
import com.mccarty.ktorapirequest.usecase.FetchWeatherUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class InterfaceModule {

    @Binds
    abstract fun provideFetchWeatherRemoteRepository(fetchWeatherRemoteRepository: FetchWeatherRemoteRepository): RemoteRepository

    @Binds
    abstract fun provideFetchWeatherUseCase(fetchWeatherUseCase: FetchWeatherUseCase): FetchWeather

    @Binds
    abstract fun provideKtorApiService(ktorApiService: WeatherApiService): Weather

}