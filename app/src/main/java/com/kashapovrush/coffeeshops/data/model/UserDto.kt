package com.kashapovrush.coffeeshops.data.model

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("login") val login: String,
    @SerializedName("password") val password: String
)
