package com.example.donmvvmtemplate

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Job

open class BaseViewModel : ViewModel() {


    override fun onCleared() {
        super.onCleared()
    }
}