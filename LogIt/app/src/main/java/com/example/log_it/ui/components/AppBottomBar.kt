/*
* AppBottomBar.kt
* Creates the bottom app bar with navigation or action buttons
*/
package com.example.log_it.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun AppBottomBar()
{
    BottomAppBar(
        actions =
            {
                IconButton(onClick = { /**/ })
                {
                    Icon(imageVector = Icons.TwoTone.Search, contentDescription = "Search Button")
                }
            },
        tonalElevation = 8.dp
    )
}