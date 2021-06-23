package com.example.donmvvmtemplate.model.network

import com.example.donmvvmtemplate.model.vo.LocationResponseVO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {


    @GET("location/search/?query=se")
    fun searchLocation(): Call<ArrayList<LocationResponseVO>>

}