package com.example.donmvvmtemplate.model.network

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val client by lazy {
        OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
//            addInterceptor{ chain -> createHeaderChain(chain) }
        }.build()
    }

        private const val BASE_URL = "https://www.metaweather.com/api/"

        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // 받은 응답을 옵서버블 형태로 변환해 줍니다.
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync()) // 서버에서 json 형식으로 데이터를 보내고 이를 파싱해서 받아옵니다.
            .client(client)
            .build()

        val service :RetrofitService = retrofit.create(RetrofitService::class.java)



    fun get() :RetrofitService{
        return service;
    }
}