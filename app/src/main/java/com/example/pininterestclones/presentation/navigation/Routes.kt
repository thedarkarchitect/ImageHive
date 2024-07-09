package com.example.pininterestclones.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes(val screen: String) {
    @Serializable
    data object HomeScreen : Routes("home")
    @Serializable
    data object SearchScreen : Routes("search")
    @Serializable
    data object FavoritesScreen : Routes("favorite")
    @Serializable
    data class FullImageScreen(val imageId: String) : Routes("fullImage")
    @Serializable
    data class ProfileScreen(val profileLink: String) : Routes("Profile")
}