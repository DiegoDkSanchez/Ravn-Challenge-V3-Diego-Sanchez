package com.ravn_challenge.ui.features.person

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.data.models.Person
import com.domain.usecases.GetPersonUseCase
import com.domain.usecases.UpdateFavoriteUseCase
import com.ravn_challenge.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(
    private val getPersonUseCase: GetPersonUseCase,
    private val updateFavoriteUseCase: UpdateFavoriteUseCase
) : BaseViewModel() {
    val person = MutableLiveData<Person>()
    fun person(): LiveData<Person> = person

    fun getPerson(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            cleanErrors()
            loading.postValue(true)
            getPersonUseCase(id).onSuccess {
                person.postValue(it)
                loading.postValue(false)
            }.onFailure {
                error.postValue(it.message)
                loading.postValue(false)
            }
        }
    }

    fun updateFavorite(updated: Person) {
        viewModelScope.launch(Dispatchers.IO) {
            updateFavoriteUseCase(updated).onSuccess {
                person.postValue(it)
            }
        }
    }
}