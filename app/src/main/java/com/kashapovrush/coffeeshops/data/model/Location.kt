package com.kashapovrush.coffeeshops.data.model

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("point") val point: Point
)
