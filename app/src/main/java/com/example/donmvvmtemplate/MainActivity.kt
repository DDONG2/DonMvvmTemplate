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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.donmvvmtemplate.databinding.ActivityMainBinding
import com.example.donmvvmtemplate.model.preference.PreferenceManager
import com.example.donmvvmtemplate.model.preference.SharedPreferenceManager
import com.example.donmvvmtemplate.view.adapter.WeatherRecyclerAdapter
import com.example.donmvvmtemplate.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private lateinit var mainAdapter: WeatherRecyclerAdapter

    //연결될 ViewModel
    override val viewModel: MainViewModel
        get() = ViewModelProvider(this).get(MainViewModel::class.java)

    //레이아웃 ID
    override val layoutId: Int
        get() = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainAdapter = WeatherRecyclerAdapter()

        dataBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainAdapter
        }

        dataBinding.swipeLayout.setOnRefreshListener {
            dataBinding.recyclerView.visibility = View.GONE
            viewModel.getLocationWeatherInfo()
        }

//        SharedPreferenceManager.getInstance(this).putString("test", "도운")
//        var a = SharedPreferenceManager.getInstance(this).getString("test")

        dataBinding.lifecycleOwner = this

        dataBinding.loadingProgressBar.visibility = View.VISIBLE

        //데이터 요청
        viewModel.getLocationWeatherInfo()

    }

    override fun createObserveData() {
        //날씨 데이터 옵저브
        viewModel.locationWeatherLiveData.observe(this, Observer{
            mainAdapter.setWeatherList(it)

            dataBinding.swipeLayout.isRefreshing = false

            dataBinding.recyclerView.visibility = View.VISIBLE

            dataBinding.loadingProgressBar.isVisible = false
            Log.d("Doeon Test", "Test : " +  "Success")


        })


        //에러 메시지 옵저브
        viewModel.ErrorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()

            dataBinding.loadingProgressBar.isVisible = false

        })

    }


}