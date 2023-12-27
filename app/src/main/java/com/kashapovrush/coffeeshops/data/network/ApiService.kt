package com.kashapovrush.coffeeshops.data.network

import com.kashapovrush.coffeeshops.data.model.LocationDto
import com.kashapovrush.coffeeshops.data.model.MenuDto
import com.kashapovrush.coffeeshops.data.model.TokenDto
import com.kashapovrush.coffeeshops.data.model.UserDto
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
    suspend fun registerUser(@Body user: UserDto):TokenDto

    @Headers("Content-type: application/json", "accept: application/json")
    @POST("auth/login")
    suspend fun loginUser(@Body userDto: UserDto): TokenDto

    @Headers("accept: application/json")
    @GET("locations")
    fun getLocations(@Header("Authorization") token: String): Call<List<LocationDto>>

    @Headers("accept: application/json")
    @GET("location/{shop}/menu")
    fun getMenu(
        @Path("shop") shop: Int,
        @Header("Authorization") token: String
    ): Call<List<MenuDto>>



}