/*
* AppShowsScreen.kt
* Displays scrollable show content.
*/
package com.example.log_it.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppShowsScreen(paddingValues: PaddingValues)
{

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        AppShowsLazyColumn()
    }
}

@Composable
fun AppShowsLazyColumn()
{
    val state = rememberLazyListState() //stores scroll position

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(50.dp),
        contentPadding = PaddingValues(bottom = 100.dp),
        state = state
    ) {
        items(300) { index ->
            Text(text = "Show Item: $index")
        }
    }
}