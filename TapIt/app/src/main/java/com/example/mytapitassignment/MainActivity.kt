package com.example.mytapitassignment


// MainActivity.kt



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytapitassignment.ui.theme.screens.GameScreen
import com.example.mytapitassignment.ui.theme.screens.HomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "homeScreen") {
                composable("homeScreen") {
                    HomeScreen(navController)
                }
                composable("gameScreen") {
                    GameScreen(navController)
                }
            }
        }
    }
}
