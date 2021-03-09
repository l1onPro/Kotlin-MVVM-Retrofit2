package com.example.kotlin_mvvm_retrofit2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_mvvm_retrofit2.models.RecyclerList
import com.example.kotlin_mvvm_retrofit2.newtwork.RetroInstance
import com.example.kotlin_mvvm_retrofit2.newtwork.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    val recyclerListLiveData: MutableLiveData<RecyclerList> = MutableLiveData()

    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getDataFromApi("ny")
            recyclerListLiveData.postValue(response)
        }
    }
}