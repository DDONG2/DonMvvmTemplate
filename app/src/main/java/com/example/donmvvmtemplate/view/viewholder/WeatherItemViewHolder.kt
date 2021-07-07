package com.example.donmvvmtemplate.view.viewholder

import android.content.Context
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.donmvvmtemplate.databinding.ItemLocalWeatherViewBinding
import com.example.donmvvmtemplate.model.vo.LocationResponseVO

class WeatherItemViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView) {

    private var binding: ItemLocalWeatherViewBinding

    init {
        binding = DataBindingUtil.bind(itemView)!!
    }


    fun bind(item: LocationResponseVO) {

        item.title?.let {
            binding.localTitleTextView.text = it
        }


//        item.todayWeather?.let {
//
//            binding.todayTemper.text = "${it.temper}\u2103"
//            binding.todayHumidity.text = "${it.humidity}%"
//
//            binding.todayWeatherName.text = it.weatherStatus.fullName
//
//            GlideHelper.load(
//                binding.todayWeatherIcon,
//                context.getString(R.string.icon_url, it.weatherStatus.status)
//            )
//        }
//
//        item.tomorrowWeather?.let {
//
//            binding.tomorrowTemper.text = "${it.temper}\u2103"
//            binding.tomorrowHumidity.text = "${it.humidity}%"
//
//            binding.tomorrowWeatherName.text = it.weatherStatus.fullName
//
//            GlideHelper.load(
//                binding.tomorrowWeatherIcon,
//                context.getString(R.string.icon_url, it.weatherStatus.status)
//            )
//        }
    }

}