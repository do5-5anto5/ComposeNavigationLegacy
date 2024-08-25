package com.do55anto5.composenavigationlegacy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.do55anto5.composenavigationlegacy.screens.HomeScreen
import com.do55anto5.composenavigationlegacy.screens.ProductDetailsScreen
import com.do55anto5.composenavigationlegacy.screens.ProductListScreen

@Composable
fun SetupNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home_screen") {

        composable(route = "home_screen") {
            HomeScreen(
                navigateToProductListScreen = {
                    navController.navigate("product_list_screen")
                }
            )
        }

        composable(route = "product_list_screen") {
            ProductListScreen(
                navigateToProductDetailsScreen = {
                    navController.navigate("product_details_screen")
                },
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = "product_details_screen") {
            ProductDetailsScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}