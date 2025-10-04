@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.log_it

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Add
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.log_it.ui.theme.LogItTheme

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

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun AppHome()
{
    LogItTheme(
        darkTheme = true
    ) {
        Scaffold(
            topBar = {
                AppTopBar()
            },
            bottomBar = {
                AppBottomBar()
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /**/ },
                    shape = CircleShape
                ) {
                    Icon(
                        imageVector = Icons.TwoTone.Add,
                        contentDescription = "Floating Action Button"
                    )
                }
            }
        ) { paddingValues ->
            AppContent(
                paddingValues = paddingValues
            )
        }
    }
}

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

//make the bottom app car a bit more rounded
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
    )
}

@Composable
fun AppContent(paddingValues: PaddingValues)
{
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(3.5.dp)
        ) {
            Text(text = "Hello from content area!")
            HorizontalDivider(
                thickness = 0.2.dp
                // color = Color.Blue
            )
            Text(text = "This part is in a column which means it all automatically lines up")
        }
    }
}