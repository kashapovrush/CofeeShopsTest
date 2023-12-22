package com.kashapovrush.cofeeshopstest.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kashapovrush.cofeeshopstest.data.model.Token
import com.kashapovrush.cofeeshopstest.data.network.ApiFactory
import com.kashapovrush.cofeeshopstest.ui.theme.CofeeShopsTestTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CofeeShopsTestTheme {

            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            val token = ApiFactory.apiService.registerUser("Rus", "1234")
            Log.d("MainActivityTest", "token ${token.token}")
            Log.d("MainActivityTest", "token ${token.lifeTime}")
        }

    }

}
