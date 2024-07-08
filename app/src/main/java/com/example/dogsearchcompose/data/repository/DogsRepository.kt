package com.example.dogsearchcompose.data.repository

import com.example.dogsearchcompose.data.network.service.DogApiService
import javax.inject.Inject

class DogsRepository @Inject constructor(
    private val dogApiService: DogApiService
) {

    suspend fun getDogsByBreedsFromApi(query: String): List<String> {
        return dogApiService.getDogsImagesByBreeds(query)
    }
}