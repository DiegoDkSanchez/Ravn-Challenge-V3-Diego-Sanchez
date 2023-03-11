package com.domain.repository

import com.data.models.Person
import com.ravn_challenge.GetAllPeopleQuery
import com.ravn_challenge.GetPersonQuery

interface StarWarsRepository {
    suspend fun getAllPeople() : List<Person>
    suspend fun getPerson(id: String) : Person
}