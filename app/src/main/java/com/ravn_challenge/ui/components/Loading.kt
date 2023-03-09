package com.ravn_challenge.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ravn_challenge.R
import com.ravn_challenge.ui.theme.Gray

@Preview
@Composable
fun Loading() {
    Row(
        Modifier.fillMaxWidth().padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CircularProgressIndicator(color = MaterialTheme.colorScheme.surfaceVariant)
        Box(modifier = Modifier.width(20.dp))
        Text(
            text = "Loading",
            color = MaterialTheme.colorScheme.surfaceVariant,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_bold)),
        )
    }
}
