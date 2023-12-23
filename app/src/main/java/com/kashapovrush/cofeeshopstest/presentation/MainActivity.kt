package com.kashapovrush.cofeeshopstest.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kashapovrush.cofeeshopstest.data.model.Token
import com.kashapovrush.cofeeshopstest.data.model.User
import com.kashapovrush.cofeeshopstest.presentation.ViewModel.AuthViewModel
import com.kashapovrush.cofeeshopstest.presentation.signInScreen.SignInScreen
import com.kashapovrush.cofeeshopstest.ui.theme.CofeeShopsTestTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
                val viewModel: AuthViewModel = viewModel(factory = viewModelFactory)
                val token = viewModel.registerUser((User("Rushdghdfghdfg", "rush")))
                token.enqueue(object : Callback<Token> {
                    override fun onResponse(call: Call<Token>, response: Response<Token>) {
                        Log.d("MainActivityTest", "token ${response.body()?.token}")
                    }

                    override fun onFailure(call: Call<Token>, t: Throwable) {
                        Log.d("MainActivityTest", "token is null")
                    }

                })



                SideEffect {



                }


                SignInScreen(viewModelFactory = viewModelFactory, user = (User("Rush", "rush"))) {

                }
            }
        }
    }

}
