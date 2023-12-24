package com.kashapovrush.cofeeshopstest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kashapovrush.cofeeshopstest.data.model.User
import com.kashapovrush.cofeeshopstest.navigation.AppNavGraph
import com.kashapovrush.cofeeshopstest.navigation.rememberNavigationState
import com.kashapovrush.cofeeshopstest.presentation.ViewModel.ViewModelFactory
import com.kashapovrush.cofeeshopstest.presentation.coffeeShopsScreen.CoffeeShopsScreen
import com.kashapovrush.cofeeshopstest.presentation.loginScreen.RegisterScreen
import com.kashapovrush.cofeeshopstest.presentation.menuScreen.MenuScreen
import com.kashapovrush.cofeeshopstest.presentation.paymentScreen.PaymentScreen
import com.kashapovrush.cofeeshopstest.presentation.registerScreen.LoginScreen
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
                            user = User("Rush", "rush"),
                            context = this,
                            navigationState = navigationState
                        )
                    },
                    loginScreenContent = {
                        LoginScreen(
                            viewModelFactory = viewModelFactory,
                            user = User("Rush", "rush"),
                            context = this,
                            navigationState = navigationState
                        )
                    },
                    coffeeShopsScreenContent = { CoffeeShopsScreen(navigationState) },
                    menuScreenContent = { MenuScreen(navigationState) },
                    mapScreenContent = { },
                    paymentScreenContent = {
                        PaymentScreen()
                    })
            }
        }
    }

}
