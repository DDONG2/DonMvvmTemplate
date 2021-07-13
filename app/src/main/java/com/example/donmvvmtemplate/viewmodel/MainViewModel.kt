package com.example.donmvvmtemplate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
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


    private val innerErrorMessage = MutableLiveData<String>()
    val ErrorMessage: LiveData<String>
        get() = innerErrorMessage



    //레퍼지토리 데이터 요청
     fun getLocationWeatherInfo() {

        /*
        Dispatchers.Main : 안드로이드의 메인 쓰레드입니다. UI 작업은 여기서 처리되어야 합니다.
        Dispatchers.IO : Disk 또는 네트워크에서 데이터 읽는 I/O 작업은 이 쓰레드에서 처리되어야 합니다. 예를들어, 파일을 읽거나 AAC의 Room 등도 여기에 해당됩니다.
        Dispatchers.Default : 그외 CPU에서 처리하는 대부분의 작업들은 이 쓰레드에서 처리하면 됩니다.
        */

        viewModelScope.launch {
            val response = weatherRepository.requestWeatherApi()
            withContext(Dispatchers.Main) { //withContext() 의 다음 코드를 수행하지 않습니다. withContext()가 수행되고 난후 다음 코드가 실행됩니다.  또한 UI 변경등은 Main쓰레드 에서 실행해야합니다.
                if (response.isSuccessful) {
                    innerLocationLiveData.value = response.body()
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }


    private fun onError(message: String) {
        innerErrorMessage.postValue(message)
    }

}

