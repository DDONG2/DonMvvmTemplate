package com.example.donmvvmtemplate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.donmvvmtemplate.BaseViewModel
import com.example.donmvvmtemplate.model.vo.LocationResponseVO
import com.example.donmvvmtemplate.repository.WeatherRepository

class MainViewModel : BaseViewModel() {

    private val weatherRepository: WeatherRepository

    init {
        weatherRepository = WeatherRepository()
    }

    // inner로 감싼 이유는 캡슐화를 위함
    private val innerLocationLiveData = MutableLiveData<List<LocationResponseVO>>()
    val locationWeatherLiveData: LiveData<List<LocationResponseVO>>
        get() = innerLocationLiveData

    //레퍼지토리 데이터 요청
    fun getLocationWeatherInfo() {
        weatherRepository.requestWeatherApi().let { innerLocationLiveData::setValue }
    }

}