package com.example.filmflow.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.filmflow.screens.details.MovieDetailScreen
import com.example.filmflow.screens.home.HomeScreen

@Composable

fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = MovieScreens.HomeScreen.name) {
        composable(MovieScreens.HomeScreen.name) {
            //enter the composable function for the HomeScreen
            HomeScreen(navController = navController)
        }

        composable(MovieScreens.MovieDetailScreen.name+"/{movieName}",
            arguments = listOf(navArgument("movieName")
            {
                type = NavType.StringType
            })
        ) {backStackEntry ->
            //enter the composable function for the MovieDetailScreen
            MovieDetailScreen(navController = navController,
                backStackEntry.arguments?.getString("movieName"))
        }
    }
}