package com.example.mytapitassignment.ui.theme.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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