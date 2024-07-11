package com.example.pininterestclones.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
//import androidx.navigation.compose.composable
import com.example.pininterestclones.presentation.favorites_screen.FavoritesScreen
import com.example.pininterestclones.presentation.full_image_screen.FullImageScreen
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
        ) {
            val viewModel = viewModel<HomeViewModel>()
            HomeScreen(
                images = viewModel.images,
                onImageClick = { imageId ->
                    navController.navigate(Routes.FullImageScreen(imageId).screen)
                }
            )
        }

        composable(
            route = Routes.SearchScreen.screen
        ) {
            SearchScreen()
        }

        composable(
            route = Routes.FavoritesScreen.screen
        ) {
            FavoritesScreen()
        }

        composable(
            route = Routes.FullImageScreen("{$IMAGE_ID_ARG}").screen,
            arguments = listOf(navArgument(IMAGE_ID_ARG) { type = NavType.StringType })
        ) { backStackEntry ->
            val imageId = backStackEntry.arguments?.getString(IMAGE_ID_ARG) ?: ""
            FullImageScreen(imageId = imageId) {
                navController.navigateUp()
            }
        }

        composable(
            route = Routes.ProfileScreen("{$PROFILE_LINK_ARG}").screen,
            arguments = listOf(navArgument(PROFILE_LINK_ARG) { type = NavType.StringType })
        ){ backStackEntry ->
            val profileLink = backStackEntry.arguments?.getString(PROFILE_LINK_ARG) ?: ""
//            ProfileScreen(profileLink = profileLink)
        }
    }
}

const val IMAGE_ID_ARG = "imageId"
const val PROFILE_LINK_ARG = "profileLink"