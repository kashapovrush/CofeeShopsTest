package com.kashapovrush.coffeeshops.domain.coffeeShops

import com.kashapovrush.coffeeshops.data.model.LocationDto
import com.kashapovrush.coffeeshops.data.model.MenuDto
import com.kashapovrush.coffeeshops.domain.entity.Location
import com.kashapovrush.coffeeshops.domain.entity.Menu
import com.kashapovrush.coffeeshops.domain.entity.Payment
import kotlinx.coroutines.flow.Flow
import retrofit2.Call

interface CoffeeShopsRepository {

    suspend fun getLocations(token: String): Call<List<LocationDto>>

    suspend fun getMenu(shop: Int, token: String): Call<List<MenuDto>>

    suspend fun addPaymentItem(payment: Payment)

    fun getListPayments(): Flow<List<Payment>>
}