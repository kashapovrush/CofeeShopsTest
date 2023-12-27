package com.kashapovrush.coffeeshops.data.model

import com.google.gson.annotations.SerializedName

data class Point(
    @SerializedName("latitude") val latitude: Float,
    @SerializedName("longitude") val longitude: Float
)
