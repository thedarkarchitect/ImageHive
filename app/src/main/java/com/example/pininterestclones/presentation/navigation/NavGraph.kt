package com.example.pininterestclones.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pininterestclones.presentation.favorites_screen.FavoritesScreen
import com.example.pininterestclones.presentation.home_screen.HomeScreen
import com.example.pininterestclones.presentation.home_screen.HomeViewModel
import com.example.pininterestclones.presentation.search_screen.SearchScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.HomeScreen.screen
    ){
        composable(
            route = Routes.HomeScreen.screen
        ){
            val viewModel = viewModel<HomeViewModel>()
            HomeScreen(
                images = viewModel.images,
                onImageClick = {}
            )
        }

        composable(
            route = Routes.SearchScreen.screen
        ){
            SearchScreen()
        }

        composable(
            route = Routes.FavoritesScreen.screen
        ){
            FavoritesScreen()
        }
    }
}