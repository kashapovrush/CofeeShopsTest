package com.kashapovrush.cofeeshopstest.domain.coffeeShops

import com.kashapovrush.cofeeshopstest.data.model.Location
import com.kashapovrush.cofeeshopstest.data.model.Menu
import retrofit2.Call

interface CoffeeShopsRepository {

    suspend fun getLocations(token: String): Call<List<Location>>

    suspend fun getMenu(shop: Int, token: String): Call<List<Menu>>
}