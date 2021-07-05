package com.example.donmvvmtemplate.repository

import com.example.donmvvmtemplate.model.vo.LocationResponseVO
import retrofit2.Response

interface WeatherRepositoryImpl {

    suspend fun requestWeatherApi() : Response<ArrayList<LocationResponseVO>>
}