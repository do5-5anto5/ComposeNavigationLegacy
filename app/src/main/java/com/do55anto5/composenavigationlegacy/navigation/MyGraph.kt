package com.do55anto5.composenavigationlegacy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.do55anto5.composenavigationlegacy.model.User
import com.do55anto5.composenavigationlegacy.screens.HomeScreen
import com.do55anto5.composenavigationlegacy.screens.ProductDetailsScreen
import com.do55anto5.composenavigationlegacy.screens.ProductListScreen
import com.do55anto5.composenavigationlegacy.util.fromJson
import com.do55anto5.composenavigationlegacy.util.toJson

@Composable
fun SetupNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home_screen") {

        composable(route = "home_screen") {
            HomeScreen(
                navigateToProductListScreen = { user ->
                    navController.navigate("product_list_screen/${user.toJson()}")
                }
            )
        }

        composable(
            route = "product_list_screen/{user}",
            arguments = listOf(navArgument("user") { type = NavType.StringType })
            ) { navBackStackEntry ->

            val user = navBackStackEntry.arguments?.getString("user")?.fromJson<User>()

            ProductListScreen(
                user = user,
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