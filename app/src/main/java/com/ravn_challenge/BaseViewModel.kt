package com.ravn_challenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {
    val loading = MutableLiveData(false)
    val error = MutableLiveData("")

    fun loading(): LiveData<Boolean> = loading
    fun error(): LiveData<String> = error

    fun cleanErrors() {
        error.postValue("")
    }
}