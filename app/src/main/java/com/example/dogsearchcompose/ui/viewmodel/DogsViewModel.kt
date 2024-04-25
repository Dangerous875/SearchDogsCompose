package com.example.dogsearchcompose.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogsearchcompose.domain.GetDogsByBreed
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogsViewModel @Inject constructor(private val getDogsByBreed: GetDogsByBreed) : ViewModel() {

    private val _listDogs = MutableStateFlow<List<String>>(emptyList())
    val lisDogs = _listDogs.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    fun getDogsByBreeds(query: String) {
        Log.i("asd", query)
        _isLoading.value = true
        viewModelScope.launch {
            val response = getDogsByBreed(query)
            _listDogs.value = response
            _isLoading.value = false
        }
    }
}