package com.kashapovrush.cofeeshopstest.data.network

import com.kashapovrush.cofeeshopstest.data.model.Token
import com.kashapovrush.cofeeshopstest.data.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers("Content-type: application/json", "accept: application/json")
    @POST("auth/register")
    fun registerUser(@Body user: User):Call<Token>

    @Headers("Content-type: application/json", "accept: application/json")
    @POST("auth/login")
    fun loginUser(@Body user: User): Call<Token>

}