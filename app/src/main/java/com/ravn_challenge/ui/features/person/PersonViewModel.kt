package com.ravn_challenge.ui.features.person

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.domain.models.Person
import com.domain.usecases.GetPersonUseCase
import com.ravn_challenge.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(
    private val getPersonUseCase: GetPersonUseCase
) : BaseViewModel() {
    val person = MutableLiveData<Person>()
    fun person(): LiveData<Person> = person

    fun getPerson(id: String) {
        viewModelScope.launch {
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
}