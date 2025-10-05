/*
* AppHome.kt
* Defines the main composable screen of the app.
* Sets up the top bar,
* bottom bar,
* content area,
* and floating action button using Scaffold layout.
* Composable entry point for main screen layout.
*/
package com.example.log_it.ui.screen

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import com.example.log_it.ui.components.*

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun AppHome()
{
    var selectedScreen by remember{mutableStateOf(Screen.Movies) }
    Scaffold(
        topBar = { AppTopBar() },
        bottomBar = { AppBottomBar(selectedScreen = selectedScreen, onScreenSelected = {selectedScreen = it})},
        floatingActionButton = {
            AppFloatingActionButton(
                onClick = { /**/ },
                shape = CircleShape
            )
        }
    ) { padding ->
        when(selectedScreen)
        {
            Screen.Movies -> AppMoviesScreen(padding)
            Screen.Shows -> AppShowsScreen(padding)
        }
    }
}

@Composable
fun AppFloatingActionButton(onClick: () -> Unit, shape: Shape)
{
    FloatingActionButton(
        onClick = onClick,
        shape = shape
    ) {
        Icon(
            imageVector = Icons.TwoTone.Add,
            contentDescription = "Add Item"
        )
    }
}

enum class Screen { Movies, Shows }