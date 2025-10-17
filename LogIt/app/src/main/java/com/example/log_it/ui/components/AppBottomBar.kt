/*
* AppBottomBar.kt
* Creates the bottom app bar with navigation or action buttons
*/
package com.example.log_it.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp


@Composable
fun AppBottomBar(onHomeClick: () -> Unit, onMoviesClick: () -> Unit, onShowsClick: () -> Unit)
{
    BottomAppBar(
        actions =
            {
                TextButton(onClick = onHomeClick) {
                    Icon(imageVector = Icons.Outlined.Home, contentDescription = "Home Screen Button")
                }

                TextButton(onClick = onMoviesClick)
                {
                    Icon(imageVector = Icons.Outlined.Favorite, contentDescription = "Movie Screen Button")
                }
                TextButton(onClick = onShowsClick) {
                    Icon(imageVector = Icons.Outlined.Star, contentDescription = "Show Screen Button")
                }
            },
        tonalElevation = 8.dp
    )
}