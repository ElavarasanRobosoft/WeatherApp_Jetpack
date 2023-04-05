package com.robosoft.weatherappjetpack.presentation.home

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.robosoft.weatherapp.navigationdrawer.DrawerBody
import com.robosoft.weatherapp.navigationdrawer.DrawerHeader
import com.robosoft.weatherapp.navigationdrawer.MenuItem
import com.robosoft.weatherappjetpack.R
import com.robosoft.weatherappjetpack.presentation.navigation.AppBar
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Box {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.background_android),
            contentScale = ContentScale.FillBounds,
            contentDescription = "Background"
        )
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        Scaffold(
            scaffoldState = scaffoldState,
            backgroundColor = Color.Transparent,
            topBar = {
                AppBar(
                    onNavigationIconClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    },navController
                )
            },
            drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
            drawerContent = {
                DrawerHeader()
                DrawerBody(
                    items = listOf(
                        MenuItem(
                            id = "home",
                            title = "Home",
                            contentDescription = "Go to home screen",
                            icon = Icons.Default.Home
                        ),
                        MenuItem(
                            id = "favourite",
                            title = "Favourite",
                            contentDescription = "Go to favourite screen",
                            icon = Icons.Default.Star
                        ),
                        MenuItem(
                            id = "recent",
                            title = "Recent Screen",
                            contentDescription = "Go to recent screen",
                            icon = Icons.Default.Search
                        )
                    ), onItemClick = {
                        when (it.id) {
                            "home" -> navController.navigate("Home_Screen")
                            "favourite" -> navController.navigate("Favourite_screen")
                            "recent" -> navController.navigate("Recent_screen")
                        }
                    }
                )
            })
        {
            HomeContent()
        }
    }
}