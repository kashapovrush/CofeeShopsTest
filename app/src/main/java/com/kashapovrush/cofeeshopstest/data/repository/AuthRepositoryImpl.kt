package com.kashapovrush.cofeeshopstest.data.repository

import com.kashapovrush.cofeeshopstest.data.model.Token
import com.kashapovrush.cofeeshopstest.data.model.User
import com.kashapovrush.cofeeshopstest.data.network.ApiService
import com.kashapovrush.cofeeshopstest.domain.auth.AuthRepository
import retrofit2.Call
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): AuthRepository {

    override fun loginUser(user: User): Call<Token> {
        return apiService.loginUser(user)
    }

    override fun registerUser(user: User): Call<Token> {
        return apiService.registerUser(user)
    }



}