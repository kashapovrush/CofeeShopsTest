package com.kashapovrush.cofeeshopstest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class NavigationState(
    val navHostController: NavHostController
) {

    fun navigateTo(route: String) {
        navHostController.navigate(route) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }

            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToCoffeeShops(token: String) {
        navHostController.navigate(Screen.CoffeeShopsScreen.getRouteWithArgs(token))
    }

    fun navigateToMenu(shop: Int, token: String) {
        navHostController.navigate(Screen.MenuScreen.getRoute(shop, token))
    }
}

@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
):NavigationState {
    return NavigationState(navHostController)
}