package com.kashapovrush.coffeeshops.domain.auth

import com.kashapovrush.coffeeshops.domain.entity.Token
import com.kashapovrush.coffeeshops.domain.entity.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(private val repository: AuthRepository) {


    operator fun invoke(user: User): Flow<Token> {
        return repository.registerUser(user)
    }
}
