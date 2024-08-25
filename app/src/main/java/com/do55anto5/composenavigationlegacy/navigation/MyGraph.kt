package com.do55anto5.composenavigationlegacy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.do55anto5.composenavigationlegacy.screens.HomeScreen
import com.do55anto5.composenavigationlegacy.screens.ProductDetailsScreen
import com.do55anto5.composenavigationlegacy.screens.ProductListScreen

@Composable
fun SetupNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home_screen") {

        composable(route = "home_screen") {
            HomeScreen(
                navigateToProductListScreen = { name ->
                    navController.navigate("product_list_screen/$name")
                }
            )
        }

        composable(
            route = "product_list_screen/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
            ) { navBackStackEntry ->

            val name = navBackStackEntry.arguments?.getString("name") ?: ""

            ProductListScreen(
                name = name,
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