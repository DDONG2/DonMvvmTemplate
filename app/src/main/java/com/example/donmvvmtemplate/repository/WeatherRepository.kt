package com.example.donmvvmtemplate.repository

import android.util.Log
import com.example.donmvvmtemplate.model.network.RetrofitClient
import com.example.donmvvmtemplate.model.vo.LocationResponseVO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository {

//    fun requestLocationApi(onError: (Throwable) -> Unit, onNext: (List<BaseApiResponse>) -> Unit) {
//
//        NetworkBinder().apply {
//            setDisposable(disposable)
//            setOnError { onError(it) }
//            setOnNextList { onNext(it) }
//        }.executeListResponse(ApiController.weatherApiService.searchLocation())
//    }
    var LocationData = ArrayList<LocationResponseVO>();

    fun requestWeatherApi() : ArrayList<LocationResponseVO> {
        val mLocation =
            LocationResponseVO(title = "김철수", location_type = "가가", woeid = 12, latt_long = "11")
        val client = RetrofitClient.get().searchLocation()
        client.enqueue(object : Callback<ArrayList<LocationResponseVO>> {
            override fun onResponse(
                call: Call<ArrayList<LocationResponseVO>>,
                response: Response<ArrayList<LocationResponseVO>>
            ) {
                if (response.isSuccessful) {
                     LocationData = response.body() as ArrayList<LocationResponseVO>

                }


            }

            override fun onFailure(call: Call<ArrayList<LocationResponseVO>>, t: Throwable) {
            }

        })
            return LocationData
    }


}


