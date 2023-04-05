package com.robosoft.weatherappjetpack.presentation.recent_search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.robosoft.weatherappjetpack.R

@Composable

fun Recent(navController: NavController) {
    Box {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.background_android),
            contentScale = ContentScale.FillBounds,
            contentDescription = "Background"
        )
        RecentContent(navController)
    }
}
