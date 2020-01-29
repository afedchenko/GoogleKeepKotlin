package com.example.googlekeeperkotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val viewStateLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        viewStateLiveData.value = "Это старый "
    }

    fun viewState() : LiveData<String> = viewStateLiveData

    fun updateHello() {
        viewStateLiveData.value = "А это новый "
    }
}
