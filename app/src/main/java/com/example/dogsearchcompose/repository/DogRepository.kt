package com.example.dogsearchcompose.repository

import com.example.dogsearchcompose.data.network.DogService
import javax.inject.Inject

class DogRepository @Inject constructor(private val dogService: DogService) {

    suspend fun getDogsByName(query :String):List<String>{
        return dogService.getDogsByName(query)
    }
}