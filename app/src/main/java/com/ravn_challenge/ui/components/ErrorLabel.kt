package com.ravn_challenge.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.ravn_challenge.ui.theme.Red

@Composable
fun ErrorLabel(message: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = message,
            color = Red,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_bold)),
        )
    }
}

@Preview
@Composable
fun ErrorPreview() {
    ErrorLabel(message = "Failed to Load Data")
}