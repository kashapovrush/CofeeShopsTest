package com.kashapovrush.coffeeshops.domain

data class Payment(
    val id: Int,
    val name: String,
    val count: Int,
    val price: Int
)
