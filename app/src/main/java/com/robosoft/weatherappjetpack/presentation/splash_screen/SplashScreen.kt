package com.robosoft.weatherappjetpack.presentation.splash_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.robosoft.weatherappjetpack.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(key1 = true) {
        delay(3000L)
        navController.navigate("Home_Screen")
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .paint(
            painter = painterResource(id = R.drawable.background_android),
            contentScale = ContentScale.FillBounds
        )
    )
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center ) {
        Image(
            painter = painterResource(id = R.drawable.logo_splash),
            contentDescription = "Splash screen logo", alignment = Alignment.Center
        )
    }
}