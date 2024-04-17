package com.example.dogsearchcompose.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogsearchcompose.data.network.APIDog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogsViewModel @Inject constructor(private val apiDog: APIDog) : ViewModel() {

    private val _listDogs = MutableStateFlow<List<String>>(emptyList())
    val lisDogs = _listDogs.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    fun getDogsByBreeds(query: String) {
        Log.i("asd", query)
        _isLoading.value = true
        viewModelScope.launch {
            val response = apiDog.getDogsByBreeds(query)
            _listDogs.value = response.body()?.images ?: emptyList()
            _isLoading.value = false
        }
    }
}