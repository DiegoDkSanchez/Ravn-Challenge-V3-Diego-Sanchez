package com.domain.usecases

import com.data.repository.StarWarsRepository
import com.domain.models.Person
import com.domain.utils.DomainMapper
import javax.inject.Inject

class GetPersonUseCase @Inject constructor(
    private val startWarsRepository: StarWarsRepository,
    private val mapper: DomainMapper,
) {
    suspend operator fun invoke(id: String): Result<Person> {
        return try {
            val queryPerson = startWarsRepository.getPerson(id)
            Result.success(mapper.toPersonComplete(queryPerson))
        } catch (e: Error) {
            Result.failure(Error("Failed to Load Data"))
        }
    }
}