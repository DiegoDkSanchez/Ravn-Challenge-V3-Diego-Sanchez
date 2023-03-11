package com.ravn_challenge.ui.features.person

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ravn_challenge.R
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
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
            personData?.let { person ->
                Box(modifier = Modifier.height(40.dp))
                if (!loading)
                    Button(
                        onClick = {viewModel.updateFavorite(person)},
                        Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = 20.dp
                            )
                    ) {
                        Text(
                            text = if (person.favorite) stringResource(
                                id = R.string.remove_favorite
                            ) else stringResource(
                                id = R.string.add_favorite
                            ),
                        )
                    }
            }

        }
    }
}