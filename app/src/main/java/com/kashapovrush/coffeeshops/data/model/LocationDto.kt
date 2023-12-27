package com.kashapovrush.coffeeshops.data.model

import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("point") val pointDto: PointDto
)
