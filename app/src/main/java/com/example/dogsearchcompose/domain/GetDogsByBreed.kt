package com.example.dogsearchcompose.domain

import com.example.dogsearchcompose.repository.DogRepository
import javax.inject.Inject

class GetDogsByBreed @Inject constructor(private val dogRepository: DogRepository) {

    suspend operator fun invoke(breed: String): List<String> {
        return dogRepository.getDogsByName(breed)
    }
}