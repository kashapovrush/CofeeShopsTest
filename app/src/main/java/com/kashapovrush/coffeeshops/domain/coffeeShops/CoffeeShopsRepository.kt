package com.kashapovrush.coffeeshops.domain.coffeeShops

import com.kashapovrush.coffeeshops.domain.entity.Location
import com.kashapovrush.coffeeshops.domain.entity.Menu
import com.kashapovrush.coffeeshops.domain.entity.Payment
import kotlinx.coroutines.flow.Flow

interface CoffeeShopsRepository {

    fun getLocations(token: String): Flow<List<Location>>

    fun getMenu(shop: Int, token: String): Flow<List<Menu>>

    suspend fun addPaymentItem(payment: Payment)

    fun getListPayments(): Flow<List<Payment>>
}