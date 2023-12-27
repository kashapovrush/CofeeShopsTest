package com.kashapovrush.coffeeshops.data.repository

import com.kashapovrush.coffeeshops.data.model.Token
import com.kashapovrush.coffeeshops.data.model.User
import com.kashapovrush.coffeeshops.data.network.ApiService
import com.kashapovrush.coffeeshops.domain.auth.AuthRepository
import retrofit2.Call
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): AuthRepository {

    override suspend fun loginUser(user: User): Call<Token> {
        return apiService.loginUser(user)
    }

    override suspend fun registerUser(user: User): Call<Token> {
        return apiService.registerUser(user)
    }



}