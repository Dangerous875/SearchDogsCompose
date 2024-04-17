package com.example.dogsearchcompose.data.network

import com.example.dogsearchcompose.data.model.DogsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIDog {

    @GET("{dogBreed}/images")
    suspend fun getDogsByBreeds(@Path("dogBreed") query : String):Response<DogsResponse>
}