package com.example.mytapitassignment.data

import android.content.Context
import android.content.SharedPreferences

object SharedPreferencesHelper {
    // Constant values to represent the name of the SharedPreferences file and the keys used within it
    private const val PREFERENCES_NAME = "MyTapItGamePrefs"
    private const val HIGH_SCORE_KEY = "HighScore"

    // Function to get an instance of the SharedPreferences
    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    // Function to save a high score into SharedPreferences
    fun saveHighScore(context: Context, score: Int) {
        val editor = getSharedPreferences(context).edit()
        editor.putInt(HIGH_SCORE_KEY, score)
        editor.apply()
    }

    // Function to retrieve the high score from SharedPreferences
    fun getHighScore(context: Context): Int {
        return getSharedPreferences(context).getInt(HIGH_SCORE_KEY, 0)
    }
}
