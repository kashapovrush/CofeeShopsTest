package com.kashapovrush.coffeeshops.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "payments")
data class PaymentDb (
    @PrimaryKey
    val id: Int,
    val name: String,
    val count: Int,
    val price: Int
)

