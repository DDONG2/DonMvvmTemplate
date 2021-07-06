package com.example.donmvvmtemplate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.donmvvmtemplate.BaseViewModel
import com.example.donmvvmtemplate.model.vo.LocationResponseVO
import com.example.donmvvmtemplate.repository.WeatherRepository
import kotlinx.coroutines.*

class MainViewModel : BaseViewModel() {

    private val weatherRepository: WeatherRepository

    //에러처리를 위함 https://codechacha.com/ko/android-coroutine/
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    init {
        weatherRepository = WeatherRepository()
    }

    // inner로 감싼 이유는 캡슐화를 위함
    private val innerLocationLiveData = MutableLiveData<List<LocationResponseVO>>()
    val locationWeatherLiveData: LiveData<List<LocationResponseVO>>
        get() = innerLocationLiveData

    private val innerLoading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = innerLoading

    private val innerErrorMessage = MutableLiveData<String>()
    val ErrorMessage: LiveData<String>
        get() = innerErrorMessage


    //레퍼지토리 데이터 요청
     fun getLocationWeatherInfo() {

        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = weatherRepository.requestWeatherApi()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    innerLocationLiveData.postValue(response.body())
                    innerLoading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }


    private fun onError(message: String) {
        innerErrorMessage.postValue(message)
        innerLoading.postValue(false)
    }

}

