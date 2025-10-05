/*
* AppTopBar.kt
* Displays the top app bar with the app title and scroll behavior settings.
*/

@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.log_it.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp

@Composable
fun AppTopBar()
{
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Log-It",
                fontSize = 50.sp,
                //textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                letterSpacing = 0.sp,
                fontStyle = FontStyle.Italic
            )
        },
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    )
}