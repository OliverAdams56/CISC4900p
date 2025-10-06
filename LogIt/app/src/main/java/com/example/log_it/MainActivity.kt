/*
* MainActivity.kt
* Entry point of the application.
* Initializes edge-to-edge display,
* sets the app theme,
* and loads the main composable screen (AppHome).
*/

@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.log_it

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.log_it.ui.theme.LogItTheme
import com.example.log_it.ui.screen.AppHome

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            LogItTheme {
                AppHome()
            }
        }
    }
}

/*
@Composable
fun AppTopBar()
{
    TopAppBar(
        title = {
            Text(
                text = "Log-It",
                fontSize = 50.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                letterSpacing = 0.sp,
                fontStyle = FontStyle.Italic
            )
        },
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    )
}
*/
/*
/*
* TODO make the bottom app bar a bit more rounded
*/
@Composable
fun AppBottomBar()
{
    BottomAppBar(
        actions = {
            IconButton(
                onClick = { /**/ }
            ) {
                Icon(
                    imageVector = Icons.TwoTone.Search,
                    contentDescription = "Search Button"
                )
            }
        },
        tonalElevation = 100.dp
    )
}
*/