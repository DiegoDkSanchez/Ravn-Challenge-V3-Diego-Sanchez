package com.domain.usecases

import com.data.repository.StarWarsRepository
import com.domain.models.Person
import com.domain.utils.DomainMapper
import javax.inject.Inject

class GetAllPeopleUseCase @Inject constructor(
    private val starWarsRepository: StarWarsRepository,
    private val domainMapper: DomainMapper,
) {
    suspend operator fun invoke(): Result<List<Person>> {
        return try {
            val queryPeople = starWarsRepository.getAllPeople()
            Result.success(queryPeople.map { person -> domainMapper.toPerson(person)}.toList())
        } catch (e: Error) {
            Result.failure(Error("Failed to Load Data"))
        }
    }
}
