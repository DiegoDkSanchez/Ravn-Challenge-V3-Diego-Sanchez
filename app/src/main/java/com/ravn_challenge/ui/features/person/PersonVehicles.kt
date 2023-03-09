package com.ravn_challenge.ui.features.person

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.domain.models.Vehicle
import com.ravn_challenge.ui.theme.BlackMain
import com.ravn_challenge.ui.theme.Gray

@Composable
fun PersonVehicles(vehicles: List<Vehicle>) {
    if (vehicles.isNotEmpty()) {
        Column(
            Modifier.padding(start = 20.dp)
        ) {
            Box(Modifier.height(40.dp))
            Text("Vehicles", color = BlackMain)
            Box(Modifier.height(10.dp))
            LazyColumn {
                items(vehicles) { vehicle ->
                    Text(
                        vehicle.name,
                        color = Gray,
                        modifier = Modifier
                            .padding(vertical = 15.dp)
                            .padding(end = 20.dp),
                    )
                    Divider()
                }
            }
        }
    }
}