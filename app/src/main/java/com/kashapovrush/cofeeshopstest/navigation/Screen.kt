package com.kashapovrush.cofeeshopstest.navigation

import android.net.Uri
import com.google.gson.Gson
import com.kashapovrush.cofeeshopstest.domain.Payment

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
    object PaymentScreen: Screen(ROUTE_PAYMENT) {

        private const val ROUTE_FOR_PAYMENT = "route_payment"

        fun getRouteForPayment(shop: Int, token: String, payment: Payment): String {
            val paymentJson = Gson().toJson(payment)
            return "${ROUTE_FOR_PAYMENT}/$shop/$token/${Uri.encode(paymentJson)}"
        }

    }

    companion object {

        private const val ROUTE_LOGIN = "route_login"
        private const val ROUTE_REGISTER = "route_register"
        private const val ROUTE_COFFEE_SHOPS = "route_coffee_shops/{token}"
        private const val ROUTE_MAP = "route_map"
        private const val ROUTE_MENU = "route_menu/{shop}/{token}"
        private const val ROUTE_PAYMENT = "route_payment/{shop}/{token}/{payment}"
    }
}
