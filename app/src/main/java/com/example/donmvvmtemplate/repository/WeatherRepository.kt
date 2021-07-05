package com.example.donmvvmtemplate.repository

import android.util.Log
import com.example.donmvvmtemplate.model.network.RetrofitClient
import com.example.donmvvmtemplate.model.vo.LocationResponseVO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository : WeatherRepositoryImpl {


    override suspend fun requestWeatherApi() = RetrofitClient.get().searchLocation()



}


