package com.example.dogsearchcompose.ui.testDetail.model.hero

import com.example.testcombat.data.model.SuperHeroAppearance
import com.example.testcombat.data.model.SuperHeroBiography
import com.example.testcombat.data.model.SuperHeroImage
import com.example.testcombat.data.model.SuperHeroItem
import com.example.testcombat.data.model.SuperHeroPowerStats
import javax.inject.Inject

class Hero @Inject constructor() {

    val superHero = SuperHeroItem(
        id = "70", name = "Batman",
        powerStats = SuperHeroPowerStats(
            intelligence = "100",
            strength = "26",
            speed = "27",
            durability = "100",
            power = "47",
            combat = "100"
        ),
        biography = SuperHeroBiography(
            fullName = "Bruce Wayne",
            firstAppearance = "Detective Comics #27",
            publisher = "DC Comics",
            alignment = "good"
        ),
        appearance = SuperHeroAppearance(gender = "Male", race = "Human"),
        image = SuperHeroImage(url = "https://www.superherodb.com/pictures2/portraits/10/100/639.jpg")
    )
}