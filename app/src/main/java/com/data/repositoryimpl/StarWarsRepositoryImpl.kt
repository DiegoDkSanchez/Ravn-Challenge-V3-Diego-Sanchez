package com.data.repositoryimpl

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.coroutines.await
import com.domain.repository.StarWarsRepository
import com.ravn_challenge.GetAllPeopleQuery
import com.ravn_challenge.GetPersonQuery
import javax.inject.Inject

class StarWarsRepositoryImpl @Inject constructor(
    private val apolloClient: ApolloClient
) : StarWarsRepository {
    override suspend fun getAllPeople(): List<GetAllPeopleQuery.Person?> {
        return try {
            val response = apolloClient.query(GetAllPeopleQuery()).await()
            response.data?.allPeople?.people ?: kotlin.run {
                throw Error("Failed to Load Data")
            }
        } catch (error: Exception) {
            throw Error("Failed to Load Data")
        }
    }

    override suspend fun getPerson(id: String): GetPersonQuery.Person? {
        return try {
            val response = apolloClient.query(GetPersonQuery(id = Input.optional(id))).await()
            response.data?.person ?: kotlin.run {
                throw Error("Failed to Load Data")
            }
        } catch (error: Exception) {
            throw Error("Failed to Load Data")
        }
    }
}