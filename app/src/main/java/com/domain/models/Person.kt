package com.domain.models

data class Person(
    val id: String,
    val name: String,
    val species: String,
    val planet: String,
    val eyeColor: String,
    val hairColor: String,
    val skinColor: String,
    val birthYear: String,
    val vehicles: List<Vehicle>
)
