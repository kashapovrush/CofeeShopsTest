package com.kashapovrush.coffeeshops.data.model

import com.google.gson.annotations.SerializedName

data class MenuDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("imageURL") val imageUrl: String,
    @SerializedName("price") val price: Int
)
