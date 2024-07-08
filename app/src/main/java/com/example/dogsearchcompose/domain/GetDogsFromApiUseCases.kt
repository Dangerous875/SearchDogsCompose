package com.example.dogsearchcompose.domain

import com.example.dogsearchcompose.data.repository.DogsRepository
import javax.inject.Inject

class GetDogsFromApiUseCases @Inject constructor(private val repository: DogsRepository) {

    suspend operator fun invoke(query:String):List<String>{
        return repository.getDogsByBreedsFromApi(query)
    }
}