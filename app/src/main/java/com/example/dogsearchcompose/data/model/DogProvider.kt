package com.example.dogsearchcompose.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DogProvider @Inject constructor() {
    var imagesDogs : List<String> = emptyList()
}