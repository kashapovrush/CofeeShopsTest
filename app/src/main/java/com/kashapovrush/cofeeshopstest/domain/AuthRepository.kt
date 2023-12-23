package com.kashapovrush.cofeeshopstest.domain

import com.kashapovrush.cofeeshopstest.data.model.Token
import com.kashapovrush.cofeeshopstest.data.model.User
import com.kashapovrush.cofeeshopstest.presentation.signInScreen.AuthState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Response

interface AuthRepository {

    fun loginUser(user: User): Call<Token>

    fun registerUser(user: User): Call<Token>
}