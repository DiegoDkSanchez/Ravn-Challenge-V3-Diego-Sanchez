package com.domain.usecases

import com.data.models.Person
import com.domain.repository.StarWarsRepository
import javax.inject.Inject

class UpdateFavoriteUseCase @Inject constructor(
    private val starWarsRepository: StarWarsRepository
) {
    suspend operator fun invoke(person: Person): Result<Person> {
        return try {
            if (person.favorite) {
                Result.success(starWarsRepository.removeFavorite(person.id))
            } else {
                Result.success(starWarsRepository.addFavorite(person.id))
            }
        } catch (e: Error) {
            Result.failure(Error("Failed to Load Data"))
        }
    }
}