package com.kashapovrush.coffeeshops.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiFactory {

    private const val BASE_URL = "http://147.78.66.203:3210/"


    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
//        .addInterceptor(Interceptor { chain ->
//            val req = chain.request()
//            val request: Request = req.newBuilder()
//                .header("content-type", "application/json")
//                .header("accept", "application/json")
//                .method(req.method, req.body)
//                .build()
//            val response = chain.proceed(request)
//            response
//        })
        .build()


    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val apiService: ApiService = retrofit.create()
}