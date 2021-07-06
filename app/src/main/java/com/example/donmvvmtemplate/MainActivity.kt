package com.example.donmvvmtemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.donmvvmtemplate.databinding.ActivityMainBinding
import com.example.donmvvmtemplate.model.preference.PreferenceManager
import com.example.donmvvmtemplate.model.preference.SharedPreferenceManager
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


//        SharedPreferenceManager.getInstance(this).putString("test", "도운")
//        var a = SharedPreferenceManager.getInstance(this).getString("test")

        dataBinding.lifecycleOwner = this

        dataBinding.progressDialog.visibility = View.VISIBLE

        //데이터 요청
        viewModel.getLocationWeatherInfo()

    }

    override fun createObserveData() {
        //날씨 데이터 옵저브
        viewModel.locationWeatherLiveData.observe(this, Observer{

            Log.d("Doeon Test", "Test : " +  "Success")

        })

        //로딩 바 옵저브
        viewModel.loading.observe(this, {
            dataBinding.progressDialog.isVisible = it

        })

        //에러 메시지 옵저브
        viewModel.ErrorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

    }


}