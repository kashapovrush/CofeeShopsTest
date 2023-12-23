package com.kashapovrush.cofeeshopstest.data.network

import com.kashapovrush.cofeeshopstest.data.model.Token
import com.kashapovrush.cofeeshopstest.data.model.User
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface ApiService {

    @Headers(
        "Content-type: application/json",
        "accept: application/json"
    )
    @POST("auth/register")
    fun registerUser(@Body user: User):Call<Token>

    @POST("auth/login")
    fun loginUser(@Body user: User): Token

}