/*
* AppShowsScreen.kt
* Displays scrollable show content.
*/
package com.example.log_it.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ShowItem(
    val title: String,
    val reason: String,
    val rating: Int
)

@Composable
fun AppShowsScreen(paddingValues: PaddingValues, shows: List<ShowItem>)
{
    val state = rememberLazyListState()

    if (shows.isEmpty()) {
        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            Text(
                text = "No shows added yet. Tap + to add one!",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            contentPadding = PaddingValues(bottom = 100.dp),
            state = state
        ){
            item { Spacer(modifier = Modifier.height(1.dp)) }
            items(shows) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    shape = MaterialTheme.shapes.medium,
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "🎬 ${item.title}",
                            fontSize = 20.sp,
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "💬 Why: ${item.reason}",
                            fontSize = 16.sp,
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "⭐ Rating: ${item.rating}/10",
                            fontSize = 16.sp,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AddShowDialog(
    onDismiss: () -> Unit,
    onAddShow: (String, String, Int) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var reason by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf("") }

    androidx.compose.material3.AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add a Show") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                androidx.compose.material3.OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Show Title") }
                )
                androidx.compose.material3.OutlinedTextField(
                    value = reason,
                    onValueChange = { reason = it },
                    label = { Text("Why You Like It") }
                )
                androidx.compose.material3.OutlinedTextField(
                    value = rating,
                    onValueChange = { rating = it },
                    label = { Text("Rating (1–10)") }
                )
            }
        },
        confirmButton = {
            androidx.compose.material3.TextButton(
                onClick = {
                    val numericRating = rating.toIntOrNull() ?: 0
                    if (title.isNotBlank() && reason.isNotBlank() && numericRating in 1..10) {
                        onAddShow(title, reason, numericRating)
                    }
                }
            ) {
                Text("Add")
            }
        },
        dismissButton = {
            androidx.compose.material3.TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}