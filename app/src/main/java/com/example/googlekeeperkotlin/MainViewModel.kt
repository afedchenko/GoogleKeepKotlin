package com.example.googlekeeperkotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val viewStateLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        viewStateLiveData.value = "Hello World!!!"
    }

    fun viewState() : LiveData<String> = viewStateLiveData

    fun updateHello() {
        viewStateLiveData.value = "Hello World2!!!"
    }
}