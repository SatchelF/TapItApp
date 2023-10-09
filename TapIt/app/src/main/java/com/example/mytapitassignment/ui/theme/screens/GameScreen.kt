package com.example.mytapitassignment.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mytapitassignment.ui.theme.components.BoxGrid
import com.example.mytapitassignment.viewModel.GameViewModel

@Composable
fun GameScreen(viewModel: GameViewModel,navController: NavController) {
    val colors = listOf(Color.Red, Color.Blue, Color.Green, Color.Yellow)
    val currentLevel = remember { mutableStateOf(1) }
    val pillBoxColors = remember { mutableStateOf(mutableListOf(colors.random())) }
    val isGameOver = remember { mutableStateOf(false) }
    val isResetClicked = remember { mutableStateOf(false) }
    val currentIndex = remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
        // ... and other modifiers ...
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header text at the top of the screen
            Text(
                text = "Level ${currentLevel.value}",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp),
                color = Color.White
            )

            // Pill-shaped box
            Box(
                modifier = Modifier
                    .width(340.dp)
                    .height(80.dp)
                    .background(
                        color = pillBoxColors.value.last(),
                        shape = RoundedCornerShape(25.dp)
                    )
                    .padding(bottom = 16.dp)
            )

            if (isResetClicked.value) {
                currentLevel.value = 1
                pillBoxColors.value.clear()
                pillBoxColors.value.add(colors.random())
                isResetClicked.value = false
            }

            if (isGameOver.value) {
                viewModel.saveHighScore(currentLevel.value)
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Game Over",
                        fontSize = 60.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        color = Color.Magenta
                    )
                    Spacer(modifier = Modifier.height(16.dp))


                    // Changed the text to "Return to Main Menu" and action to navigate back
                    Button(
                        onClick = {
                            navController.navigate("homeScreen")
                        },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = "Return to Main Menu")
                    }
                }
            }

            BoxGrid(currentLevel, pillBoxColors, isGameOver,currentIndex)
        }
    }
}