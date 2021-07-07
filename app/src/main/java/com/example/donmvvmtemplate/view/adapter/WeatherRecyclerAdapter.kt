package com.example.donmvvmtemplate.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.donmvvmtemplate.databinding.ItemHeaderViewBinding
import com.example.donmvvmtemplate.databinding.ItemLocalWeatherViewBinding
import com.example.donmvvmtemplate.model.vo.LocationResponseVO
import com.example.donmvvmtemplate.model.vo.WeatherViewType
import com.example.donmvvmtemplate.view.viewholder.WeatherHeaderViewHolder
import com.example.donmvvmtemplate.view.viewholder.WeatherItemViewHolder

class WeatherRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var cityList = listOf<LocationResponseVO>()


    fun setWeatherList(weatherList : List<LocationResponseVO>){
        this.cityList = weatherList
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {

        if (position == 0)
            return WeatherViewType.HEADER.value

        return WeatherViewType.ITEM.value
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType) {

            WeatherViewType.ITEM.value -> {
                val binding = ItemLocalWeatherViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return WeatherItemViewHolder(binding.root, parent.context)
            }

            else -> {
                val binding = ItemHeaderViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return WeatherHeaderViewHolder(binding.root)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       if (holder is WeatherItemViewHolder)
           holder.bind(cityList.get(position -1))
        else
           return
    }

    override fun getItemCount(): Int {
       return cityList.size + 1
    }


}