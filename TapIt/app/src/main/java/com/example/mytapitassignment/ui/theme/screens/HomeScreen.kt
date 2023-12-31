package com.example.mytapitassignment.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mytapitassignment.ui.theme.components.BoxGrid
import com.example.mytapitassignment.viewModel.GameViewModel

@Composable
fun HomeScreen(viewModel: GameViewModel,navController: NavController) {
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
            Text(
                text = "TAP IT!",
                fontSize = 100.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp, bottom = 100.dp),
                color = Color.White
            )
            Text(
                text = "High Score: ${viewModel.highScore.value}",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp, bottom = 32.dp),
                color = Color.White
            )

            Text(
                text = "High Score: 0",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Play Game button
            Button(
                onClick = { navController.navigate("gameScreen") },
                modifier = Modifier
                    .padding(8.dp)
                    .width(200.dp)
                    .height(60.dp)
            ) {
                Text(text = "Play Game", fontSize = 24.sp)
            }
        }
    }
}



