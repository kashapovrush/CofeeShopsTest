package com.kashapovrush.cofeeshopstest.presentation.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kashapovrush.cofeeshopstest.data.model.Token
import com.kashapovrush.cofeeshopstest.data.model.User
import com.kashapovrush.cofeeshopstest.domain.LoginUserUseCase
import com.kashapovrush.cofeeshopstest.domain.RegisterUserUseCase
import com.kashapovrush.cofeeshopstest.presentation.signInScreen.AuthState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val loginUserUseCase: LoginUserUseCase,
    private val registerUserUseCase: RegisterUserUseCase
): ViewModel() {

    fun loginUser(user: User) = loginUserUseCase(user)
//        .filter { it.token.isNotEmpty() }
        .map { it.token }



    fun registerUser(user: User) = registerUserUseCase(user)



}