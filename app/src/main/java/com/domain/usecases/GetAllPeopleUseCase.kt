package com.domain.usecases

import com.domain.repository.StarWarsRepository
import com.data.models.Person
import com.data.utils.DomainMapper
import javax.inject.Inject

class GetAllPeopleUseCase @Inject constructor(
    private val starWarsRepository: StarWarsRepository,
) {
    suspend operator fun invoke(): Result<List<Person>> {
        return try {
            Result.success(starWarsRepository.getAllPeople())
        } catch (e: Error) {
            Result.failure(Error("Failed to Load Data"))
        }
    }
}
