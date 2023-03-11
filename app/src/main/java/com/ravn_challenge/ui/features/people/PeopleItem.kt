package com.ravn_challenge.ui.features.people

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.data.models.Person
import com.ravn_challenge.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PeopleItem(person: Person, onTap: () -> Unit,) {
    val name = person.name
    val species = person.species
    val planet = person.planet
    Surface(
        onClick = onTap,
        enabled = true,
    ) {
        Column(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Row(
                modifier = Modifier.padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = name,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                    )
                    Text(
                        text = "$species from $planet",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat_thin)),
                    )
                }
                Icon(
                    ImageVector.vectorResource(R.drawable.ic_right),
                    contentDescription = "RightArrow"
                )
                Box(Modifier.width(16.dp))
            }
            Divider()
        }
    }
}