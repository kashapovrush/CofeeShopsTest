package com.kashapovrush.coffeeshops.data.model

import com.google.gson.annotations.SerializedName

data class TokenDto(
    @SerializedName("token") val token: String,
    @SerializedName("tokenLifetime") val lifeTime: Int
)
