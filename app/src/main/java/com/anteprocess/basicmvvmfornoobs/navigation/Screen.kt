package com.anteprocess.basicmvvmfornoobs.navigation

sealed class Screen(val route: String) {
    object Main : Screen(route = "main")
}