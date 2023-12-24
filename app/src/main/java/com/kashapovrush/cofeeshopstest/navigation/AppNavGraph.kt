package com.kashapovrush.cofeeshopstest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    registerScreenContent: @Composable () -> Unit,
    loginScreenContent: @Composable () -> Unit,
    coffeeShopsScreenContent: @Composable () -> Unit,
    menuScreenContent: @Composable () -> Unit,
    mapScreenContent: @Composable () -> Unit,
    paymentScreenContent: @Composable () -> Unit,

    ) {
    NavHost(navController = navHostController, startDestination = Screen.RegisterScreen.route) {
        composable(Screen.RegisterScreen.route) {
            registerScreenContent()
        }
        composable(Screen.LoginScreen.route) {
            loginScreenContent()
        }
        composable(Screen.CoffeeShopsScreen.route) {
            coffeeShopsScreenContent()
        }
        composable(Screen.MapScreen.route) {
            mapScreenContent()
        }
        composable(Screen.MenuScreen.route) {
            menuScreenContent()
        }
        composable(Screen.PaymentScreen.route) {
            paymentScreenContent()
        }
    }
}