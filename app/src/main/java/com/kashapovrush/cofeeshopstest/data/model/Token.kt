package com.kashapovrush.cofeeshopstest.data.model

import com.google.gson.annotations.SerializedName

data class Token(
    @SerializedName("token") val token: String,
    @SerializedName("tokenLifetime") val lifeTime: Long
)
