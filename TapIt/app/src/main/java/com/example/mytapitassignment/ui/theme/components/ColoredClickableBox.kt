package com.example.mytapitassignment.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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