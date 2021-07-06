package com.example.donmvvmtemplate.Fragment

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.donmvvmtemplate.R
import com.example.donmvvmtemplate.databinding.FragmentMainBinding
import com.example.donmvvmtemplate.viewmodel.MainViewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {
    override val viewModel: MainViewModel
        get() = ViewModelProvider(this, BaseViewModelFactory()).get(MainViewModel::class.java)

    override val layoutId: Int
        get() = R.layout.fragment_main

    override fun createObserveData() {

    }

    override fun initView() {

    }

    override fun initArgument(bundle: Bundle) {

    }


    companion object {

        fun newInstance() = MainFragment()

    }
}