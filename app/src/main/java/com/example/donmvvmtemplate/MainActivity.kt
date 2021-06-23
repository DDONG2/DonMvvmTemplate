package com.example.donmvvmtemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.donmvvmtemplate.databinding.ActivityMainBinding
import com.example.donmvvmtemplate.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    //연결될 ViewModel
    override val viewModel: MainViewModel
        get() = ViewModelProvider(this).get(MainViewModel::class.java)

    //레이아웃 ID
    override val layoutId: Int
        get() = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataBinding.lifecycleOwner = this

        //데이터 요청
        viewModel.getLocationWeatherInfo()

    }

    override fun createObserveData() {
        viewModel.locationWeatherLiveData.observe(this, Observer{

            Log.d("Doeon Test", "Test : " +  "Success")

        })    }


}