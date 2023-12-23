package com.kashapovrush.cofeeshopstest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kashapovrush.cofeeshopstest.data.model.User
import com.kashapovrush.cofeeshopstest.presentation.ViewModel.ViewModelFactory
import com.kashapovrush.cofeeshopstest.presentation.signInScreen.SignInScreen
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
                    SignInScreen(
                        viewModelFactory = viewModelFactory,
                        user = (User("Rush", "rush")),
                        context = this
                    )

            }
        }
    }

}
