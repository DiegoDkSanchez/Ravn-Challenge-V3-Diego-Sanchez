package com.ravn_challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ravn_challenge.ui.features.people.PeopleScreen
import com.ravn_challenge.ui.features.people.PeopleViewModel
import com.ravn_challenge.ui.features.person.PersonScreen
import com.ravn_challenge.ui.features.person.PersonViewModel
import com.ravn_challenge.ui.theme.Ravn_challengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHost = rememberNavController()
            Ravn_challengeTheme {
                NavHost(navController = navHost, startDestination = "people") {
                    composable("people") {
                        val viewModel = hiltViewModel<PeopleViewModel>()
                        PeopleScreen(viewModel = viewModel, navController = navHost)
                    }
                    composable("person/{personId}/{name}") {
                        val viewModel = hiltViewModel<PersonViewModel>()
                        val idPerson = it.arguments?.getString("personId") ?: ""
                        val name = it.arguments?.getString("name") ?: ""
                        PersonScreen(idPerson, name, viewModel, navHost)
                    }
                }
            }
        }
    }
}

