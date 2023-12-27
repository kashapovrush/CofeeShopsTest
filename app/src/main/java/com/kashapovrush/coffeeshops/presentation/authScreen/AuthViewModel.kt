package com.kashapovrush.coffeeshops.presentation.authScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kashapovrush.coffeeshops.data.model.Token
import com.kashapovrush.coffeeshops.data.model.User
import com.kashapovrush.coffeeshops.domain.auth.LoginUserUseCase
import com.kashapovrush.coffeeshops.domain.auth.RegisterUserUseCase
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val loginUserUseCase: LoginUserUseCase,
    private val registerUserUseCase: RegisterUserUseCase
): ViewModel() {

    private val _loginState = MutableLiveData<String>()
    val loginState: LiveData<String> = _loginState

    private val _registerState = MutableLiveData<String>()
    val registerState: LiveData<String> = _registerState

    fun loginUser(user: User)  {
        viewModelScope.launch {
            loginUserUseCase(user).enqueue( object : Callback<Token> {
                override fun onResponse(call: Call<Token>, response: Response<Token>) {
                    _loginState.value = response.body()?.token
                }

                override fun onFailure(call: Call<Token>, t: Throwable) {
                    _loginState.value = null
                }

            })
        }

    }


    fun registerUser(user: User) {
        viewModelScope.launch {
            registerUserUseCase(user).enqueue(object : Callback<Token> {
                override fun onResponse(call: Call<Token>, response: Response<Token>) {
                    _registerState.value = response.body()?.token
                }

                override fun onFailure(call: Call<Token>, t: Throwable) {
                    _registerState.value = ""
                }

            })
        }

    }




}