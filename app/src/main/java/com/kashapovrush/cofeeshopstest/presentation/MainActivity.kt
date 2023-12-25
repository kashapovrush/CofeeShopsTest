package com.kashapovrush.cofeeshopstest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kashapovrush.cofeeshopstest.navigation.AppNavGraph
import com.kashapovrush.cofeeshopstest.navigation.rememberNavigationState
import com.kashapovrush.cofeeshopstest.presentation.coffeeShopsScreen.CoffeeShopsScreen
import com.kashapovrush.cofeeshopstest.presentation.authScreen.RegisterScreen
import com.kashapovrush.cofeeshopstest.presentation.coffeeShopsScreen.MenuScreen
import com.kashapovrush.cofeeshopstest.presentation.coffeeShopsScreen.PaymentScreen
import com.kashapovrush.cofeeshopstest.presentation.authScreen.LoginScreen
import com.kashapovrush.cofeeshopstest.ui.theme.CofeeShopsTestTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (application as CoffeeShopsApplication).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)


        setContent {
            CofeeShopsTestTheme {


                val navigationState = rememberNavigationState()

                AppNavGraph(
                    navHostController = navigationState.navHostController,
                    registerScreenContent = {

                        RegisterScreen(
                            viewModelFactory = viewModelFactory,
                            lifecycleOwner = this,
                            navigationState = navigationState
                        )
                    },
                    loginScreenContent = {
                        LoginScreen(
                            viewModelFactory = viewModelFactory,
                            lifecycleOwner = this,
                            navigationState = navigationState
                        )
                    },
                    coffeeShopsScreenContent = { token ->
                        CoffeeShopsScreen(
                            navigationState = navigationState,
                            viewModelFactory = viewModelFactory,
                            token = token
                        ) {
                            navigationState.navHostController.popBackStack()
                        }
                    },
                    menuScreenContent = { shop, token ->
                        MenuScreen(
                            navigationState = navigationState,
                            viewModelFactory = viewModelFactory,
                            token = token,
                            shop = shop
                        ) {
                            navigationState.navHostController.popBackStack()
                        }

                    },
                    mapScreenContent = { },
                    paymentScreenContent = { shop, token, payment ->
                        PaymentScreen(
                            viewModelFactory = viewModelFactory,
                            shop = shop,
                            token = token,
                            payment = payment
                        ) {
                            navigationState.navHostController.popBackStack()
                        }
                    })
            }
        }
    }

}
