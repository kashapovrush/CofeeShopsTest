package com.kashapovrush.coffeeshops.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface PaymentDao {

    @Query("SELECT * FROM payments")
    fun getList(): List<PaymentDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPaymentItem(paymentDb: PaymentDb)
}