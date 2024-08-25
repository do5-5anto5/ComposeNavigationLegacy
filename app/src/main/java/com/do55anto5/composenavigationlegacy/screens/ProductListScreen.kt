package com.do55anto5.composenavigationlegacy.screens


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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProductListScreen(
    name: String?,
    result: String?,
    navigateToProductDetailsScreen: () -> Unit,
    navigateBack: () -> Unit
) {
    ProductListContent(
        name = name,
        result = result,
        navigateToProductDetailsScreen = navigateToProductDetailsScreen,
        navigateBack = navigateBack
    )
}

@Composable
fun ProductListContent(
    name: String?,
    result: String?,
    navigateToProductDetailsScreen: () -> Unit,
    navigateBack: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Text(text = "Product List Screen")

            Text(text = "Name: $name")

            Text(text = "Result: $result")

            Button(onClick = navigateToProductDetailsScreen,
                content = {
                    Text(text = "Go to Product Details Screen")
                }
            )
            Button(onClick = navigateBack,
                content = {
                    Text(text = "Go back")
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ListProductPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProductListContent(
            name = "John Doe",
            result = "Jetpack Compose Navigation",
            navigateToProductDetailsScreen = {},
            navigateBack = {}
        )
    }
}