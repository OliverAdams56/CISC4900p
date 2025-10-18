/*
* MainActivity.kt
* Entry point of the application.
* Initializes edge-to-edge display,
* sets the app theme,
* and loads the main composable screen (AppHome).
*/

@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.log_it

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.log_it.ui.theme.LogItTheme
import com.example.log_it.ui.components.AppHome

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            LogItTheme {
                AppHome()
            }
        }
    }
}