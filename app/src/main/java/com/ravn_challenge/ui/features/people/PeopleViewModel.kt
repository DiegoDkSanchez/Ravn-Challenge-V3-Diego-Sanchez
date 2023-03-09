package com.ravn_challenge.ui.features.people

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.domain.models.Person
import com.domain.usecases.GetAllPeopleUseCase
import com.ravn_challenge.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val getAllPeopleUseCase: GetAllPeopleUseCase
) : BaseViewModel() {
    val people = MutableLiveData<List<Person>>()
    fun people(): LiveData<List<Person>> = people

    fun getPeople() {
        viewModelScope.launch {
            cleanErrors()
            loading.postValue(true)
            getAllPeopleUseCase().onSuccess {
                people.postValue(it)
                loading.postValue(false)
            }.onFailure {
                error.postValue(it.message)
                loading.postValue(false)
            }
        }
    }
}