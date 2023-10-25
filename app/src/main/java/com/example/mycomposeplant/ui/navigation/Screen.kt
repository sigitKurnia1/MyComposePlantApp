package com.example.mycomposeplant.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object About : Screen("about_page")
    object Detail : Screen("home/{plantId}") {
        fun createRoute(plantId: String) = "home/$plantId"
    }
}