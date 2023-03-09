package com.ravn_challenge.ui.features.people

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.ravn_challenge.R
import com.ravn_challenge.ui.components.AppBar
import com.ravn_challenge.ui.components.ErrorLabel
import com.ravn_challenge.ui.components.Loading
import com.ravn_challenge.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PeopleScreen(viewModel: PeopleViewModel, navController: NavHostController) {
    val people by viewModel.people().observeAsState(listOf())
    val loading by viewModel.loading().observeAsState(false)
    val error by viewModel.error().observeAsState("")
    viewModel.getPeople()
    Scaffold(
        topBar = {
            AppBar(title = stringResource(R.string.people_title))
        },
        containerColor = White
    ) {
        Column {
            if (error.isNotBlank())
                ErrorLabel(message = error)
            if (loading)
                Loading()
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(people) { person ->
                    PeopleItem(
                        person,
                        onTap = {
                            navController.navigate("person/${person.id}/${person.name}")
                        }
                    )
                }
            }
        }
    }

}