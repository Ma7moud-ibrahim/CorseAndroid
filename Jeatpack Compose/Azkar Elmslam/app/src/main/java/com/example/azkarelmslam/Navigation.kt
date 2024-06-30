package com.example.azkarelmslam

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object VMGeneralScreen : Screen("vm_general_screen")
    object AyatAlKursiScreen : Screen("ayat_al_kursi_screen")
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.VMGeneralScreen.route) {
        composable(Screen.VMGeneralScreen.route) {
            VMGeneralScreen(navController)
        }
        composable(Screen.AyatAlKursiScreen.route) {
            AyatAlKursiScreen()
        }
    }
}
