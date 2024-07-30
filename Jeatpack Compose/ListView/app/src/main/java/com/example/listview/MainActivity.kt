package com.example.listview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.listview.ui.theme.ListViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListViewTheme {
                GymsAround()
            }
        }
    }
    @Composable
   private fun GymsAround(){
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "gyms") {
            composable(route = "gyms"){
                GymsScreen{id->
                    navController.navigate("gyms/$id")
                }
            }
            composable(
                route = "gyms/{gym_id}", arguments = listOf(navArgument("gym_id") {
                    type = NavType.IntType
                }), deepLinks = listOf(
                    navDeepLink {
                        uriPattern = "https://www.gymsaround.com/detaitls/{gym_id}"
                    }
            )) {
                GymsDetailsScreen()
            }
        }
    }
}
//sh-3.2# adb shell an start -W -a android. intent. action. VIEW -d "https:((www.qy•saround.com/detaiIs/7"