package com.ravn_challenge.ui.features.person

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.ravn_challenge.ui.components.AppBar
import com.ravn_challenge.ui.components.ErrorLabel
import com.ravn_challenge.ui.components.Loading
import com.ravn_challenge.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonScreen(
    idPerson: String,
    name: String,
    viewModel: PersonViewModel,
    navController: NavHostController,
) {
    viewModel.getPerson(idPerson)
    val personData by viewModel.person().observeAsState()
    val loading by viewModel.loading().observeAsState(false)
    val error by viewModel.error().observeAsState("")

    Scaffold(
        topBar = {
            AppBar(title = name, goBack = navController)
        },
        containerColor = White
    ) {
        Column {
            if (error.isNotBlank())
                ErrorLabel(message = error)
            if (loading)
                Loading()
            personData?.let { person ->
                PersonGeneralInformation(person)
            }
            personData?.vehicles?.let { vehicles ->
                PersonVehicles(vehicles)
            }
        }
    }
}