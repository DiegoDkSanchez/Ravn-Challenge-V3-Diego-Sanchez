package com.ravn_challenge.features.people

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.domain.repository.StarWarsRepository
import com.data.models.Person
import com.domain.usecases.GetAllPeopleUseCase
import com.data.utils.DomainMapper
import com.ravn_challenge.GetAllPeopleQuery
import com.ravn_challenge.TestCoroutineRule
import com.ravn_challenge.ui.features.people.PeopleViewModel
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
class PeopleViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var starWarsRepository: StarWarsRepository

    @Test
    fun `get people list when getPeople should success`() {
        testCoroutineRule.runBlockingTest {
            val result = listOf<GetAllPeopleQuery.Person>()
            doReturn(result).`when`(starWarsRepository).getAllPeople()
            val getAllPeopleUseCase = GetAllPeopleUseCase(starWarsRepository, DomainMapper())
            val viewModel = PeopleViewModel(getAllPeopleUseCase)
            viewModel.getPeople()
            verify(starWarsRepository).getAllPeople()
            assertEquals(listOf<Person>(), viewModel.people.value)
        }
    }

    @Test
    fun `get loading state when getPeople start`() {
        testCoroutineRule.runBlockingTest {
            val result = listOf<GetAllPeopleQuery.Person>()
            doReturn(result).`when`(starWarsRepository).getAllPeople()
            val getAllPeopleUseCase = GetAllPeopleUseCase(starWarsRepository, DomainMapper())
            val viewModel = PeopleViewModel(getAllPeopleUseCase)
            viewModel.getPeople()
            verify(starWarsRepository).getAllPeople()
            assertEquals(false, viewModel.loading.value)
        }
    }

}