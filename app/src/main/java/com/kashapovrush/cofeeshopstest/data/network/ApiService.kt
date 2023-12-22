package com.kashapovrush.cofeeshopstest.data.network

import com.kashapovrush.cofeeshopstest.data.model.Token
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface ApiService {

    @FormUrlEncoded
    @POST("auth/register?accept=application/json&Content-Type=application/json")
    suspend fun registerUser(
        @Field ("login") login: String,
        @Field ("password") password: String
    ): Token

}