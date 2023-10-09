package com.example.mytapitassignment


// MainActivity.kt



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytapitassignment.ui.theme.screens.GameScreen
import com.example.mytapitassignment.ui.theme.screens.HomeScreen
import com.example.mytapitassignment.viewModel.GameViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: GameViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "homeScreen") {
                composable("homeScreen") {
                    HomeScreen(viewModel, navController)
                }
                composable("gameScreen") {
                    GameScreen(viewModel, navController)
                }
            }
        }
    }
}
