package com.data.utils

import com.data.entities.FavoritesEntity
import com.data.models.Person
import com.data.models.Vehicle
import com.ravn_challenge.GetAllPeopleQuery
import com.ravn_challenge.GetPersonQuery

class DomainMapper {
    fun toPerson(queryPerson: GetAllPeopleQuery.Person?, favorites: List<FavoritesEntity>): Person {
        val favorite : Boolean = isFavorite(queryPerson?.id, favorites)
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
            favorite
        )
    }

    fun toPersonComplete(queryPerson: GetPersonQuery.Person?, favorites: List<FavoritesEntity>): Person {
        val favorite : Boolean = isFavorite(queryPerson?.id, favorites)
        return Person(
            queryPerson?.id ?: "",
            queryPerson?.name ?: "",
            queryPerson?.species?.name ?: "Human",
            queryPerson?.homeworld?.name ?: "",
            queryPerson?.eyeColor ?: "",
            queryPerson?.hairColor ?: "",
            queryPerson?.skinColor ?: "",
            queryPerson?.birthYear ?: "",
            toVehicleList(queryPerson?.vehicleConnection?.vehicles ?: listOf()),
            favorite
        )
    }

    private fun toVehicleList(list: List<GetPersonQuery.Vehicle?>): List<Vehicle> {
        return list.map { vehicle -> Vehicle(vehicle?.name ?: "") }.toList()
    }


    private fun isFavorite(id: String?, favorites: List<FavoritesEntity>): Boolean {
        var isFavorite = false
        favorites.forEach { favorite ->
            if (favorite.id == id){
                isFavorite = true
            }
        }
        return isFavorite
    }

}