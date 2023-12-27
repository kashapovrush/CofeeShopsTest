package com.kashapovrush.coffeeshops.data.repository

import com.kashapovrush.coffeeshops.data.mapper.CoffeeShopsMapper
import com.kashapovrush.coffeeshops.data.model.TokenDto
import com.kashapovrush.coffeeshops.data.network.ApiService
import com.kashapovrush.coffeeshops.domain.auth.AuthRepository
import com.kashapovrush.coffeeshops.domain.entity.Token
import com.kashapovrush.coffeeshops.domain.entity.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: CoffeeShopsMapper
): AuthRepository {

    override fun loginUser(user: User): Flow<Token>  = flow {
         emit(mapper.mapTokenDtoToEntity(apiService.loginUser(mapper.mapUserToDto(user))))
    }.catch {
        this.emit(mapper.mapTokenDtoToEntity(TokenDto("", 0)))
    }

    override fun registerUser(user: User): Flow<Token>  = flow {
        emit(mapper.mapTokenDtoToEntity(apiService.registerUser(mapper.mapUserToDto(user))))
    }.catch {
        this.emit(mapper.mapTokenDtoToEntity(TokenDto("", 0)))
    }



}