package com.example.dogsearchcompose.data.network

import com.example.dogsearchcompose.data.model.DogsResponse
import javax.inject.Inject

class DogService @Inject constructor(private val apiDog: APIDog) {

    suspend fun getDogsByName(query : String):List<String>{
        val response = apiDog.getDogsByBreeds(query)
        return response.body()?.images ?: emptyList()
    }
}