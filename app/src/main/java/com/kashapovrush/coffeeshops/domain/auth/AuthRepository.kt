package com.kashapovrush.coffeeshops.domain.auth

import com.kashapovrush.coffeeshops.domain.entity.Token
import com.kashapovrush.coffeeshops.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun loginUser(user: User): Flow<Token>

    fun registerUser(user: User): Flow<Token>
}