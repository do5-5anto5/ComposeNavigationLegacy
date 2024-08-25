package com.do55anto5.composenavigationlegacy.screens


import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    navigateToProductListScreen: (String) -> Unit
) {
    HomeContent(
        navigateToProductListScreen = navigateToProductListScreen
    )
}

@Composable
fun HomeContent(
    navigateToProductListScreen: (String) -> Unit
) {

    val context = LocalContext.current
    val activity = context as? ComponentActivity

    var nameValue by remember { mutableStateOf("") }

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
                onClick = { navigateToProductListScreen(nameValue) },
                content = {
                    Text(text = "Go to Product List Screen")
                }
            )

            OutlinedTextField(
                value = nameValue,
                onValueChange = {
                    nameValue = it
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