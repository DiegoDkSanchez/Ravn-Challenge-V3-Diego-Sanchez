package com.ravn_challenge.features.person

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.domain.repository.StarWarsRepository
import com.data.models.Person
import com.domain.usecases.GetAllPeopleUseCase
import com.domain.usecases.GetPersonUseCase
import com.data.utils.DomainMapper
import com.ravn_challenge.GetAllPeopleQuery
import com.ravn_challenge.GetPersonQuery
import com.ravn_challenge.TestCoroutineRule
import com.ravn_challenge.ui.features.people.PeopleViewModel
import com.ravn_challenge.ui.features.person.PersonViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PersonViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var starWarsRepository: StarWarsRepository

    @Test
    fun `get person when getPerson should success`() {
        val id = "TWFKMsDASD="
        val person = Person(
            id = id,
            name = "Luke",
            species = "Human",
            planet = "Tatooine",
            eyeColor = "blue",
            hairColor = "blond",
            skinColor = "fair",
            birthYear = "19BBY",
            vehicles = listOf()
        )
        val result = GetPersonQuery.Person(
            id = id,
            name = "Luke",
            species = GetPersonQuery.Species(name = "Human"),
            homeworld = GetPersonQuery.Homeworld(name = "Tatooine"),
            eyeColor = "blue",
            hairColor = "blond",
            skinColor = "fair",
            birthYear = "19BBY",
            vehicleConnection = GetPersonQuery.VehicleConnection(vehicles = listOf())
        )
        testCoroutineRule.runBlockingTest {
            doReturn(result).`when`(starWarsRepository).getPerson(id)
            val getPersonUseCase = GetPersonUseCase(starWarsRepository, DomainMapper())
            val viewModel = PersonViewModel(getPersonUseCase)
            viewModel.getPerson(id)
            verify(starWarsRepository).getPerson(id)
            assertEquals(person, viewModel.person.value)
        }
    }

    @Test
    fun `get loading state when getPeople start`() {
        val id = "TWFKMsDASD="
        val person = Person(
            id = id,
            name = "Luke",
            species = "Human",
            planet = "Tatooine",
            eyeColor = "blue",
            hairColor = "blond",
            skinColor = "fair",
            birthYear = "19BBY",
            vehicles = listOf()
        )
        val result = GetPersonQuery.Person(
            id = id,
            name = "Luke",
            species = GetPersonQuery.Species(name = "Human"),
            homeworld = GetPersonQuery.Homeworld(name = "Tatooine"),
            eyeColor = "blue",
            hairColor = "blond",
            skinColor = "fair",
            birthYear = "19BBY",
            vehicleConnection = GetPersonQuery.VehicleConnection(vehicles = listOf())
        )
        testCoroutineRule.runBlockingTest {
            doReturn(result).`when`(starWarsRepository).getPerson(id)
            val getPersonUseCase = GetPersonUseCase(starWarsRepository, DomainMapper())
            val viewModel = PersonViewModel(getPersonUseCase)
            viewModel.getPerson(id)
            verify(starWarsRepository).getPerson(id)
            assertEquals(false, viewModel.loading.value)
        }
    }

}