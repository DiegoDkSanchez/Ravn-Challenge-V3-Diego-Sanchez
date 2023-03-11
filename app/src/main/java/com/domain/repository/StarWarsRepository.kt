package com.domain.repository

import com.ravn_challenge.GetAllPeopleQuery
import com.ravn_challenge.GetPersonQuery

interface StarWarsRepository {
    suspend fun getAllPeople() : List<GetAllPeopleQuery.Person?>
    suspend fun getPerson(id: String) : GetPersonQuery.Person?
}