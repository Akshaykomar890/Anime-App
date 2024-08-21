package com.example.animeapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.animeapp.AnimeData.util.Screen
import com.example.animeapp.presentation.detailScreen.presentation.DetailsScreen
import com.example.compose.AnimeAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeAppTheme {
                SetBarColor(color = MaterialTheme.colorScheme.inverseSurface)

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Screen.Home.route ) {
                    composable(Screen.Home.route){
                        HomeScreen(navController)
                    }
                   composable(Screen.Details.route + "/{id}",
                       arguments = listOf(
                           navArgument("id"){type = NavType.IntType}
                       )
                       ){
                       DetailsScreen()
                   }

                }

            }
        }
    }
    @Composable
    private fun SetBarColor(color: Color){
        val systemUiController = rememberSystemUiController()
        LaunchedEffect(key1 = color) {
            systemUiController.setSystemBarsColor(color)
        }
    }
}
