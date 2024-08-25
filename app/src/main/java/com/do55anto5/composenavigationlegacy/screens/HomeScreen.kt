package com.do55anto5.composenavigationlegacy.screens


import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    navigateToProductListScreen: () -> Unit
) {
    HomeContent(
        navigateToProductListScreen = navigateToProductListScreen
    )
}

@Composable
fun HomeContent(
    navigateToProductListScreen: () -> Unit
) {

    val context = LocalContext.current
    val activity = context as? ComponentActivity

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Text(text = "Home Screen")
            Button(
                onClick = navigateToProductListScreen,
                content = {
                    Text(text = "Go to Product List Screen")
                }
            )
            Button(
                onClick = { activity?.finish() },
                content = {
                    Text(text = "Close App")
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun HomePreview() {
        HomeContent(
            navigateToProductListScreen = {}
        )
}