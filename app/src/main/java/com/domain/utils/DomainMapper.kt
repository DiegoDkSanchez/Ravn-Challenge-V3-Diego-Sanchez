package com.domain.utils

import com.domain.models.Person
import com.domain.models.Vehicle
import com.ravn_challenge.GetAllPeopleQuery
import com.ravn_challenge.GetPersonQuery

class DomainMapper {
    fun toPerson(queryPerson: GetAllPeopleQuery.Person?): Person {
        return Person(
            queryPerson?.id ?: "",
            queryPerson?.name ?: "",
            queryPerson?.species?.name ?: "Human",
            queryPerson?.homeworld?.name ?: "",
            "",
            "",
            "",
            "",
            listOf(),
        )
    }

    fun toPersonComplete(queryPerson: GetPersonQuery.Person?): Person {
        return Person(
            queryPerson?.id ?: "",
            queryPerson?.name ?: "",
            queryPerson?.species?.name ?: "Human",
            queryPerson?.homeworld?.name ?: "",
            queryPerson?.eyeColor ?: "",
            queryPerson?.hairColor ?: "",
            queryPerson?.skinColor ?: "",
            queryPerson?.birthYear ?: "",
            toVehicleList(queryPerson?.vehicleConnection?.vehicles ?: listOf())
        )
    }

    private fun toVehicleList(list: List<GetPersonQuery.Vehicle?>): List<Vehicle> {
        return list.map { vehicle -> Vehicle(vehicle?.name ?: "") }.toList()
    }

}