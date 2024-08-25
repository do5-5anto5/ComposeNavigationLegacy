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
                    navController.navigate("product_list_screen?name=$name")
                }
            )
        }

        composable(
            route = "product_list_screen?name={name}",
            arguments = listOf(navArgument("name") {
                type = NavType.StringType
                nullable = true
            })
        ) { navBackStackEntry ->

            val name = navBackStackEntry.arguments?.getString("name")
            val nameDefault = "Guest"
            val result = navBackStackEntry.savedStateHandle.get<String>("result_value")

            ProductListScreen(
                // set default value
                name = name ?: nameDefault,
                result = result,
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
                navigateBack = { result ->
                    navController.previousBackStackEntry
                        ?.savedStateHandle
                        ?.set("result_value", result)
                    navController.popBackStack()
                }
            )
        }
    }
}