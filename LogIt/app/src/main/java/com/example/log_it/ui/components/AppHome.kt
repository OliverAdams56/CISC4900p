/*
* AppHome.kt
* Defines the main composable screen of the app.
* Sets up the top bar,
* bottom bar,
* content area,
* and floating action button using Scaffold layout.
*/
package com.example.log_it.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.log_it.ui.screen.AddMovieDialog
import com.example.log_it.ui.screen.AddShowDialog
import com.example.log_it.ui.screen.AppMoviesScreen
import com.example.log_it.ui.screen.AppShowsScreen
import com.example.log_it.ui.screen.MovieItem
import com.example.log_it.ui.screen.ShowItem

@Composable
fun AppHome()
{
    var currentScreen by remember { mutableStateOf("home") }
    val movies = remember { mutableStateListOf<MovieItem>() }
    val shows = remember { mutableStateListOf<ShowItem>() }
    var showAddMovieDialog by remember { mutableStateOf(false) }
    var showAddShowDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { AppTopBar(currentScreen = currentScreen) },
        bottomBar = {AppBottomBar(currentScreen = currentScreen, onHomeClick = { currentScreen = "home" }, onMoviesClick = { currentScreen = "movies" }, onShowsClick = { currentScreen = "shows" })},
        floatingActionButton =
            {
                if (currentScreen != "home")
                {
                    FloatingActionButton(onClick = {
                        when (currentScreen) {
                            "movies" -> showAddMovieDialog = true
                            "shows" -> showAddShowDialog = true
                        }
                    })
                    {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = "FAB Add Button")
                    }
                }
            }
    )
    { paddingValues ->
        when (currentScreen) {
            "home" -> AppHomeScreen(paddingValues)
            "movies" -> AppMoviesScreen(paddingValues, movies)
            "shows" -> AppShowsScreen(paddingValues, shows)
        }
        if (showAddMovieDialog) {
            AddMovieDialog(
                onDismiss = { showAddMovieDialog = false },
                onAddMovie = { title, reason, rating ->
                    movies.add(MovieItem(title, reason, rating))
                    showAddMovieDialog = false
                }
            )
        }
        if (showAddShowDialog) {
            AddShowDialog(
                onDismiss = { showAddShowDialog = false },
                onAddShow = { title, reason, rating ->
                    shows.add(ShowItem(title, reason, rating))
                    showAddShowDialog = false
                }
            )
        }
    }
}