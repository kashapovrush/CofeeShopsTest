package com.kashapovrush.coffeeshops.domain.auth

import com.kashapovrush.coffeeshops.data.model.Token
import com.kashapovrush.coffeeshops.data.model.User
import retrofit2.Call

interface AuthRepository {

    suspend fun loginUser(user: User): Call<Token>

    suspend fun registerUser(user: User): Call<Token>
}