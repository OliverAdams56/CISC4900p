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
import com.example.log_it.ui.components.AppBottomBar
import com.example.log_it.ui.components.AppContent
import com.example.log_it.ui.components.AppTopBar
import com.example.log_it.ui.theme.LogItTheme

@Composable
fun AppHome()
{
    LogItTheme()
    {
        Scaffold(
            topBar = {AppTopBar()},
            bottomBar = {AppBottomBar()},
            floatingActionButton =
            {
                FloatingActionButton(onClick = {/**/ })
                {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "FAB Add Button")
                }
            }
        )
        {
            paddingValues ->
            AppContent(paddingValues = paddingValues)
        }
    }
}