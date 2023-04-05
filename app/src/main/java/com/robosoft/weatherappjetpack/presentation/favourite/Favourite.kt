package com.robosoft.weatherappjetpack.presentation.favourite

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.robosoft.weatherappjetpack.R
import androidx.navigation.NavController

@Composable

fun Favourite(navController: NavController) {
    Box {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.background_android),
            contentScale = ContentScale.FillBounds,
            contentDescription = "Background"
        )
        FavouriteContent(navController)
    }
}
