package com.example.dogsearchcompose.data.network.service

import com.example.dogsearchcompose.data.network.APIDog
import javax.inject.Inject

class DogApiService @Inject constructor(private val apiDog: APIDog) {

    suspend fun getDogsImagesByBreeds(query : String):List<String>{
        val response = apiDog.getDogsByBreeds(query)
        return response.body()!!.images ?: emptyList()
    }
}