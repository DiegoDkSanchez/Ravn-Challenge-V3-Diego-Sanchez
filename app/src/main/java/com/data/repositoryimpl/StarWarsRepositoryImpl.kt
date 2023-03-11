package com.data.repositoryimpl

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.coroutines.await
import com.data.dao.FavoritesDao
import com.data.models.Person
import com.data.utils.DomainMapper
import com.domain.repository.StarWarsRepository
import com.ravn_challenge.GetAllPeopleQuery
import com.ravn_challenge.GetPersonQuery
import javax.inject.Inject

class StarWarsRepositoryImpl @Inject constructor(
    private val apolloClient: ApolloClient,
    private val favoritesDao: FavoritesDao,
    private val domainMapper: DomainMapper,
) : StarWarsRepository {


    override suspend fun getAllPeople(): List<Person> {
        return try {
            val response = apolloClient.query(GetAllPeopleQuery()).await()
            val favorites = favoritesDao.getFavorites()
            response.data?.allPeople?.people?.map { person ->
                domainMapper.toPerson(person, favorites)
            }?.toList() ?: kotlin.run {
                throw Error("Failed to Load Data")
            }
        } catch (error: Exception) {
            println(error)
            throw Error("Failed to Load Data")
        }
    }

    override suspend fun getPerson(id: String): Person {
        return try {
            val response = apolloClient.query(GetPersonQuery(id = Input.optional(id))).await()
            val favorites = favoritesDao.getFavorites()
            response.data?.person?.let { person ->
                domainMapper.toPersonComplete(person, favorites)
            } ?: kotlin.run {
                throw Error("Failed to Load Data")
            }
        } catch (error: Exception) {
            throw Error("Failed to Load Data")
        }
    }
}