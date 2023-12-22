package com.kashapovrush.cofeeshopstest.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login") val login: String,
    @SerializedName("password") val password: String
)
