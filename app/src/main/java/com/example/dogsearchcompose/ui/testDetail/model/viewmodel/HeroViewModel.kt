package com.example.dogsearchcompose.ui.testDetail.model.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dogsearchcompose.ui.testDetail.model.hero.Hero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HeroViewModel @Inject constructor(private val hero: Hero):ViewModel(){

    private val _hero = MutableStateFlow(hero.superHero)
    val heroo = _hero.asStateFlow()


}