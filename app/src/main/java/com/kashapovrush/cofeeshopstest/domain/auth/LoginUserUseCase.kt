package com.kashapovrush.cofeeshopstest.domain.auth

import com.kashapovrush.cofeeshopstest.data.model.Token
import com.kashapovrush.cofeeshopstest.data.model.User
import com.kashapovrush.cofeeshopstest.domain.auth.AuthRepository
import retrofit2.Call
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User): Call<Token> {
       return repository.loginUser(user)
    }
}