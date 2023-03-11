package com.domain.usecases

import com.domain.repository.StarWarsRepository
import com.data.models.Person
import com.data.utils.DomainMapper
import javax.inject.Inject

class GetPersonUseCase @Inject constructor(
    private val startWarsRepository: StarWarsRepository,
) {
    suspend operator fun invoke(id: String): Result<Person> {
        return try {
            Result.success(startWarsRepository.getPerson(id))
        } catch (e: Error) {
            Result.failure(Error("Failed to Load Data"))
        }
    }
}