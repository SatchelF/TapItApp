package com.example.mytapitassignment.viewModel



import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytapitassignment.data.SharedPreferencesHelper
import kotlinx.coroutines.launch
import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.compose.runtime.mutableStateOf


class GameViewModel(application: Application) : AndroidViewModel(application) {

    private val appContext = getApplication<Application>().applicationContext

    val highScore = mutableStateOf(SharedPreferencesHelper.getHighScore(appContext))

    fun saveHighScore(score: Int) {
        if (score > highScore.value) {
            highScore.value = score
            SharedPreferencesHelper.saveHighScore(appContext, score)
        }
    }
}
