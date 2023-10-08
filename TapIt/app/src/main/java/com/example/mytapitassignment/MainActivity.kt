package com.example.mytapitassignment


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytapitassignment.ui.theme.MyTapItAssignmentTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val colors = listOf(Color.Red, Color.Blue, Color.Green, Color.Yellow)
            MyTapItAssignmentTheme {
                val currentLevel = remember { mutableStateOf(1) }
                val pillBoxColors = remember { mutableStateOf(mutableListOf(colors.random())) }
                val isGameOver = remember { mutableStateOf(false) }
                val isResetClicked = remember { mutableStateOf(false) }
                val currentIndex = remember { mutableStateOf(0) }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray)
                        .border(4.dp, Color.LightGray, shape = RoundedCornerShape(7.dp))
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
                            pillBoxColors.value.clear() // Clear the list
                            pillBoxColors.value.add(colors.random()) // Add a new random color
                            isResetClicked.value = false // Reset
                        }
                        if (isGameOver.value) {
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
                                Button(
                                    onClick = {
                                        isResetClicked.value = true
                                        isGameOver.value = false
                                        // Additional Game Reset Button
                                    },
                                    modifier = Modifier.padding(8.dp)


                                ) {
                                    Text(text = "START OVER")
                                }
                            }
                        }

                        // BoxGrid below the pill-shaped box
                        BoxGrid(currentLevel, pillBoxColors, isGameOver,currentIndex)
                    }
                }


            }
        }
    }

    @Composable
    fun ColoredClickableBox(color: Color, onClick: () -> Unit) {
        Box(
            modifier = Modifier
                .size(170.dp)
                .background(
                    color = color,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(8.dp)
                .clickable {
                    onClick()
                }
        )
    }

    @Composable
    fun BoxGrid(
        currentLevel: MutableState<Int>,
        pillBoxColors: MutableState<MutableList<Color>>,
        isGameOver: MutableState<Boolean>,
        currentIndex: MutableState<Int>
    ) {
        val colors = listOf(Color.Red, Color.Blue, Color.Green, Color.Yellow)
        val colorIndices = remember { mutableStateListOf(0, 1, 2, 3) }

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.offset(y = 100.dp)
            ) {
                for (i in 1..2) {
                    Row() {
                        for (j in 1..2) {
                            val removedColorIndex = colorIndices.removeFirst()
                            ColoredClickableBox(
                                color = colors[removedColorIndex]
                            ) {
                                if (colors[removedColorIndex] == pillBoxColors.value[currentIndex.value]) {
                                    currentIndex.value += 1
                                    // If all colors in sequence are clicked correctly
                                    if (currentIndex.value == pillBoxColors.value.size) {
                                        currentLevel.value++
                                        pillBoxColors.value.add(colors.random())
                                        currentIndex.value = 0 // Reset the index
                                    }
                                } else {
                                    // Handle incorrect click
                                    isGameOver.value = true
                                    currentIndex.value = 0 // Reset the index
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}

