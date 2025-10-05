/*
* AppBottomBar.kt
* Creates the bottom app bar with navigation or action buttons
*/
package com.example.log_it.ui.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.example.log_it.ui.screen.Screen

@Composable
fun AppBottomBar(
selectedScreen: Screen,
onScreenSelected: (Screen) -> Unit
)
{
    BottomAppBar(
        actions = {
            NavigationButton(
                label = "Movies",
                isSelected = selectedScreen == Screen.Movies,
                onClick = { onScreenSelected(Screen.Movies)}
            )
            NavigationButton(
                label = "Shows",
                isSelected = selectedScreen == Screen.Shows,
                onClick = { onScreenSelected(Screen.Shows) }
            )
        }
    )
}

@Composable
private fun NavigationButton(label: String, isSelected: Boolean, onClick: () -> Unit) {
    val color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
    TextButton(onClick = onClick) {
        Text(text = label, color = color)
    }
}
