package com.example.dogsearchcompose.data.local

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DogProvider @Inject constructor() {
    var imagesDogs : List<String> = emptyList()
}