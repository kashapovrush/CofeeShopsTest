package com.kashapovrush.cofeeshopstest.navigation

sealed class Screen(
    val route: String
) {

    object LoginScreen: Screen(ROUTE_LOGIN)
    object RegisterScreen: Screen(ROUTE_REGISTER)
    object CoffeeShopsScreen: Screen(ROUTE_COFFEE_SHOPS) {

        private const val ROUTE_FOR_TOKEN = "route_coffee_shops"

        fun getRouteWithArgs(token: String): String {
            return "$ROUTE_FOR_TOKEN/$token"
        }
    }
    object MapScreen: Screen(ROUTE_MAP)
    object MenuScreen: Screen(ROUTE_MENU) {

        private const val ROUTE_FOR_TOKEN_MENU = "route_menu"

        fun getRoute(shop: Int, token: String): String {
            return "$ROUTE_FOR_TOKEN_MENU/$shop/$token"
        }

    }
    object PaymentScreen: Screen(ROUTE_PAYMENT)

    companion object {

        private const val ROUTE_LOGIN = "route_login"
        private const val ROUTE_REGISTER = "route_register"
        private const val ROUTE_COFFEE_SHOPS = "route_coffee_shops/{token}"
        private const val ROUTE_MAP = "route_map"
        private const val ROUTE_MENU = "route_menu/{shop}/{token}"
        private const val ROUTE_PAYMENT = "route_PAYMENT"
    }
}
