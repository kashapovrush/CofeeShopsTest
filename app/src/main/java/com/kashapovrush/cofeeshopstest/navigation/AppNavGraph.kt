package com.kashapovrush.cofeeshopstest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.kashapovrush.cofeeshopstest.domain.Payment

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    registerScreenContent: @Composable () -> Unit,
    loginScreenContent: @Composable () -> Unit,
    coffeeShopsScreenContent: @Composable (String) -> Unit,
    menuScreenContent: @Composable (Int, String) -> Unit,
    mapScreenContent: @Composable () -> Unit,
    paymentScreenContent: @Composable (Int, String, Payment) -> Unit,

    ) {
    NavHost(navController = navHostController, startDestination = Screen.RegisterScreen.route) {
        composable(Screen.RegisterScreen.route) {
            registerScreenContent()
        }
        composable(Screen.LoginScreen.route) {
            loginScreenContent()
        }
        composable(Screen.CoffeeShopsScreen.route) {
            val token = it.arguments?.getString("token") ?: ""
            coffeeShopsScreenContent(token)
        }
        composable(Screen.MapScreen.route) {
            mapScreenContent()
        }
        composable(
            route = Screen.MenuScreen.route,
            arguments = listOf(
                navArgument("shop") {
                    type = NavType.IntType
                }
            )
        ) {
            val shop = it.arguments?.getInt("shop") ?: 0
            val token = it.arguments?.getString("token") ?: ""
            menuScreenContent(shop, token)
        }
        composable(
            route = Screen.PaymentScreen.route,
            arguments = listOf(
                navArgument("shop") {
                    type = NavType.IntType
                },
                navArgument("payment") {
                    type = NavType.StringType
                }
            )
        ) {
            val shop = it.arguments?.getInt("shop") ?: 0
            val token = it.arguments?.getString("token") ?: ""
            val paymentJson = it.arguments?.getString("payment")
            val payment = Gson().fromJson(paymentJson, Payment::class.java)
            paymentScreenContent(shop, token, payment)
        }
    }
}