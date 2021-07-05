package com.example.donmvvmtemplate

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Job

open class BaseViewModel : ViewModel() {

    protected val baseDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    protected var job: Job? = null

    override fun onCleared() {
        job?.cancel()
        super.onCleared()
    }
}