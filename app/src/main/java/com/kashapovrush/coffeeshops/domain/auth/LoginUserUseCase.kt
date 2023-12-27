package com.kashapovrush.coffeeshops.domain.auth

import com.kashapovrush.coffeeshops.data.model.Token
import com.kashapovrush.coffeeshops.data.model.User
import retrofit2.Call
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User): Call<Token> {
       return repository.loginUser(user)
    }
}