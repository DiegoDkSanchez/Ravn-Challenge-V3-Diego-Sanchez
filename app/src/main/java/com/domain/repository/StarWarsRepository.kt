package com.domain.repository

import com.data.models.Person

interface StarWarsRepository {
    suspend fun getAllPeople() : List<Person>
    suspend fun getPerson(id: String) : Person
    suspend fun addFavorite(id: String) : Person
    suspend fun removeFavorite(id: String) : Person
}
