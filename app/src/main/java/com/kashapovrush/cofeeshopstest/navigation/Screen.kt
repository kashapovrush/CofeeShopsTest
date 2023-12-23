package com.kashapovrush.cofeeshopstest.navigation

sealed class Screen(
    val route: String
) {

    object LoginScreen: Screen(ROUTE_LOGIN)
    object RegisterScreen: Screen(ROUTE_REGISTER)
    object CoffeeShopsScreen: Screen(ROUTE_COFFEE_SHOPS)
    object MapScreen: Screen(ROUTE_MAP)
    object MenuScreen: Screen(ROUTE_MENU)
    object PaymentScreen: Screen(ROUTE_PAYMENT)

    companion object {

        private const val ROUTE_LOGIN = "route_login"
        private const val ROUTE_REGISTER = "route_register"
        private const val ROUTE_COFFEE_SHOPS = "route_coffee_shops"
        private const val ROUTE_MAP = "route_map"
        private const val ROUTE_MENU = "route_menu"
        private const val ROUTE_PAYMENT = "route_PAYMENT"
    }
}
