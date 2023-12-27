package com.kashapovrush.coffeeshops.domain.coffeeShops

import com.kashapovrush.coffeeshops.data.model.Location
import com.kashapovrush.coffeeshops.data.model.Menu
import com.kashapovrush.coffeeshops.domain.Payment
import kotlinx.coroutines.flow.Flow
import retrofit2.Call

interface CoffeeShopsRepository {

    suspend fun getLocations(token: String): Call<List<Location>>

    suspend fun getMenu(shop: Int, token: String): Call<List<Menu>>

    suspend fun addPaymentItem(payment: Payment)

    fun getListPayments(): Flow<List<Payment>>
}