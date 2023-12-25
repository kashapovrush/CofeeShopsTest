package com.kashapovrush.cofeeshopstest.domain.auth

import com.kashapovrush.cofeeshopstest.data.model.Token
import com.kashapovrush.cofeeshopstest.data.model.User
import retrofit2.Call

interface AuthRepository {

    suspend fun loginUser(user: User): Call<Token>

    suspend fun registerUser(user: User): Call<Token>
}