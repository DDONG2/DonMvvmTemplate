package com.example.donmvvmtemplate.model.network

import com.example.donmvvmtemplate.model.vo.LocationResponseVO
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RetrofitService {


    @GET("location/search/?query=se")
    suspend fun searchLocation(): Response<ArrayList<LocationResponseVO>>
    

}