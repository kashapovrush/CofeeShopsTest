package com.kashapovrush.cofeeshopstest.domain

import com.kashapovrush.cofeeshopstest.data.model.Token
import com.kashapovrush.cofeeshopstest.data.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(private val repository: AuthRepository) {


    operator fun invoke(user: User): Call<Token> {
        return repository.registerUser(user)
    }
}
