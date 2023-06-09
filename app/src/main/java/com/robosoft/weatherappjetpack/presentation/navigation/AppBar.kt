package com.robosoft.weatherappjetpack.presentation.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.robosoft.weatherappjetpack.R


@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit, navController: NavController
) {
    TopAppBar(title = {
        Image(
            modifier = Modifier.padding(start = 25.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Splash screen logo"
        )
    }, backgroundColor = Color.Transparent,
        contentColor = Color.White,
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Toggle Drawer")
            }
        },
    actions = {
        IconButton(onClick = { navController.navigate("Search_screen")   }) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "search")
        }
    },
    elevation = 0.dp)
}