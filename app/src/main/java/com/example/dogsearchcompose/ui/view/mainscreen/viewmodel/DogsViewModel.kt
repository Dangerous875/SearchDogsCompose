package com.example.dogsearchcompose.ui.view.mainscreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogsearchcompose.domain.GetDogsFromApiUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogsViewModel @Inject constructor(private val getDogsFromApiUseCases: GetDogsFromApiUseCases) : ViewModel() {

    private val _listDogs = MutableStateFlow<List<String>>(emptyList())
    val lisDogs = _listDogs.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    fun getDogsByBreeds(query: String) {
        _isLoading.value = true
        viewModelScope.launch {
            _listDogs.value = getDogsFromApiUseCases(query)
            delay(2000)
            _isLoading.value = false
        }
    }
}