package com.ravn_challenge.ui.features.person

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.data.models.Person
import com.ravn_challenge.R
import com.ravn_challenge.ui.theme.BlackMain
import com.ravn_challenge.ui.theme.Gray

@Composable
fun PersonGeneralInformation(person: Person) {
    Column(
        Modifier.padding(start = 20.dp)
    ) {
        Box(Modifier.height(20.dp))
        Text(stringResource(R.string.general_information), color = BlackMain)
        Box(Modifier.height(10.dp))
        Row(
            Modifier
                .padding(vertical = 15.dp)
                .padding(end = 20.dp),
        ) {
            Text(stringResource(R.string.eye_color), Modifier.weight(1f), color = Gray)
            Text(person.eyeColor, color = BlackMain)
        }
        Divider()
        Row(
            Modifier
                .padding(vertical = 15.dp)
                .padding(end = 20.dp)
        ) {
            Text(stringResource(R.string.hair_color), Modifier.weight(1f), color = Gray)
            Text(person.hairColor, color = BlackMain)
        }
        Divider()
        Row(
            Modifier
                .padding(vertical = 15.dp)
                .padding(end = 20.dp)
        ) {
            Text(stringResource(R.string.skin_color), Modifier.weight(1f), color = Gray)
            Text(person.skinColor, color = BlackMain)
        }
        Divider()
        Row(
            Modifier
                .padding(vertical = 15.dp)
                .padding(end = 20.dp)
        ) {
            Text(stringResource(R.string.birth_year), Modifier.weight(1f), color = Gray)
            Text(person.birthYear, color = BlackMain)
        }
        Divider()
    }
}