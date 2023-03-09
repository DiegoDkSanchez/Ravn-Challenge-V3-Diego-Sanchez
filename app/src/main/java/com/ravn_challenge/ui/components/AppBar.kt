package com.ravn_challenge.ui.components

import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ravn_challenge.R
import com.ravn_challenge.ui.theme.BlackMain
import com.ravn_challenge.ui.theme.White

@Composable
fun AppBar(title: String, goBack: NavHostController? = null) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                fontSize = 18.sp,
                color = White
            )
        },
        navigationIcon = {
            val navController = rememberNavController()
            if (goBack != null) {
                IconButton(onClick = { goBack.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        tint = White,
                        contentDescription = "Back"
                    )
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = BlackMain
        )
    )
}

@Preview
@Composable
fun PreviewAppBar() {
    AppBar(title = "People")
}