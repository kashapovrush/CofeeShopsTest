package com.kashapovrush.cofeeshopstest.data.network

import com.kashapovrush.cofeeshopstest.data.model.Location
import com.kashapovrush.cofeeshopstest.data.model.Menu
import com.kashapovrush.cofeeshopstest.data.model.Token
import com.kashapovrush.cofeeshopstest.data.model.User
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @Headers("Content-type: application/json", "accept: application/json")
    @POST("auth/register")
    fun registerUser(@Body user: User):Call<Token>

    @Headers("Content-type: application/json", "accept: application/json")
    @POST("auth/login")
    fun loginUser(@Body user: User): Call<Token>

    @Headers("accept: application/json")
    @GET("locations")
    fun getLocations(@Header("Authorization") token: String): Call<List<Location>>

    @Headers("accept: application/json")
    @GET("location/{shop}/menu")
    fun getMenu(
        @Path("shop") shop: Int,
        @Header("Authorization") token: String
    ): Call<List<Menu>>



}