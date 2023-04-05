package com.robosoft.weatherappjetpack.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.robosoft.weatherappjetpack.presentation.favourite.Favourite
import com.robosoft.weatherappjetpack.presentation.home.HomeScreen
import com.robosoft.weatherappjetpack.presentation.recent_search.Recent
import com.robosoft.weatherappjetpack.presentation.search.Search
import com.robosoft.weatherappjetpack.presentation.splash_screen.SplashScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Splash_Screen") {
        composable("Splash_Screen") {
            SplashScreen(navController = navController)
        }
        composable("Home_Screen") {
            HomeScreen(navController = navController)
        }
        composable("Favourite_screen"){
            Favourite(navController = navController)
        }
        composable("Recent_screen"){
            Recent(navController = navController)
        }
        composable("Search_screen"){
            Search(navController = navController)
        }
    }
}