package com.kashapovrush.coffeeshops.presentation.authScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kashapovrush.coffeeshops.domain.auth.LoginUserUseCase
import com.kashapovrush.coffeeshops.domain.auth.RegisterUserUseCase
import com.kashapovrush.coffeeshops.domain.entity.User
import kotlinx.coroutines.launch
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
            loginUserUseCase(user).collect{
                _loginState.value = it.token
            }
        }
    }


    fun registerUser(user: User) {
        viewModelScope.launch {
            registerUserUseCase(user).collect {
                _registerState.value = it.token
            }
        }

    }




}