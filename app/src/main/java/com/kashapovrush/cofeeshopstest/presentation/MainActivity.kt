package com.kashapovrush.cofeeshopstest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kashapovrush.cofeeshopstest.presentation.signInScreen.SignInScreen
import com.kashapovrush.cofeeshopstest.presentation.signUpScreen.SignUpScreen
import com.kashapovrush.cofeeshopstest.ui.theme.CofeeShopsTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CofeeShopsTestTheme {
                SignInScreen()
            }
        }
    }
}
