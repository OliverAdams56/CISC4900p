/*
* AppBottomBar.kt
* Creates the bottom app bar with navigation or action buttons
*/
package com.example.log_it.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AppBottomBar(currentScreen: String, onHomeClick: () -> Unit, onMoviesClick: () -> Unit, onShowsClick: () -> Unit)
{
    BottomAppBar(
        tonalElevation = 8.dp
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp), horizontalArrangement = Arrangement.SpaceBetween
        ){
            TextButton(onClick = onHomeClick, colors = ButtonDefaults.textButtonColors(contentColor = if (currentScreen == "home") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface))
            {
                Column(horizontalAlignment = Alignment.CenterHorizontally){
                    Icon(imageVector = Icons.Outlined.Home, contentDescription = "Home Screen Button")
                    Text("Home", fontSize = 14.sp)
                }
            }

            TextButton(onClick = onMoviesClick, colors = ButtonDefaults.textButtonColors(contentColor = if (currentScreen == "movies") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface))
            {
                Column(horizontalAlignment = Alignment.CenterHorizontally){
                    Icon(imageVector = Icons.Outlined.Favorite, contentDescription = "Movie Screen Button")
                    Text("Movies", fontSize = 14.sp)
                }
            }
            TextButton(onClick = onShowsClick, colors = ButtonDefaults.textButtonColors(contentColor = if (currentScreen == "shows") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface))
            {

                Column(horizontalAlignment = Alignment.CenterHorizontally){
                    Icon(imageVector = Icons.Outlined.Star, contentDescription = "Show Screen Button")
                    Text("Shows", fontSize = 14.sp)
                }
            }
        }
    }
}

//        actions =
//            {
//                TextButton(onClick = onHomeClick, colors = ButtonDefaults.textButtonColors(contentColor = if (currentScreen == "home") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface)) {
//                    Icon(imageVector = Icons.Outlined.Home, contentDescription = "Home Screen Button")
//                    Text("Home", fontSize = 20.sp)
//                }
//
//                TextButton(onClick = onMoviesClick, colors = ButtonDefaults.textButtonColors(contentColor = if (currentScreen == "movie") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface))
//                {
//                    Icon(imageVector = Icons.Outlined.Favorite, contentDescription = "Movie Screen Button")
//                    Text("Movies", fontSize = 20.sp)
//                }
//                TextButton(onClick = onShowsClick, colors = ButtonDefaults.textButtonColors(contentColor = if (currentScreen == "show") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface)) {
//                    Icon(imageVector = Icons.Outlined.Star, contentDescription = "Show Screen Button")
//                    Text("Shows", fontSize = 20.sp)
//                }
//            },