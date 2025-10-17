/*
* AppHome.kt
* Defines the main composable screen of the app.
* Sets up the top bar,
* bottom bar,
* content area,
* and floating action button using Scaffold layout.
*/
package com.example.log_it.ui.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.log_it.ui.components.AppBottomBar
import com.example.log_it.ui.components.AppHomeScreen
import com.example.log_it.ui.components.AppTopBar
import com.example.log_it.ui.theme.LogItTheme

@Composable
fun AppHome()
{
    LogItTheme()
    {
        // State to track the current screen: "home", "movies", or "shows"
        // Manual state: control which screen shows via a variable.
        var currentScreen by remember { mutableStateOf("home") }

        Scaffold(
            topBar = { AppTopBar(currentScreen = currentScreen) },
            bottomBar = {AppBottomBar(onHomeClick = { currentScreen = "home" }, onMoviesClick = { currentScreen = "movies" }, onShowsClick = { currentScreen = "shows" })},
            floatingActionButton =
                {
                    FloatingActionButton(onClick = {
                        when(currentScreen) {
                            "home" -> { /* Add home action */ }
                            "movies" -> { /* Add a new movie */ }
                            "shows" -> { /* Add a new show */ }
                        }
                    })
                    {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = "FAB Add Button")
                    }
                }
        )
        { paddingValues ->
            when (currentScreen) {
                "home" -> AppHomeScreen(paddingValues)
                "movies" -> AppMoviesScreen(paddingValues)
                "shows" -> AppShowsScreen(paddingValues)
            }

        }
    }
}