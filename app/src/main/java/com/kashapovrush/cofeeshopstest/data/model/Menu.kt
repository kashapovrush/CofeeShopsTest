package com.kashapovrush.cofeeshopstest.data.model

import com.google.gson.annotations.SerializedName

data class Menu(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("imageURL") val imageUrl: String,
    @SerializedName("price") val price: Int
)
