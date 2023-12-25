package com.kashapovrush.cofeeshopstest.domain.coffeeShops

import com.kashapovrush.cofeeshopstest.data.model.Menu
import retrofit2.Call
import javax.inject.Inject

class GetMenuUseCase @Inject constructor(private val repository: CoffeeShopsRepository) {

    suspend operator fun  invoke(shop: Int, token: String): Call<List<Menu>> {
        return repository.getMenu(shop, token)
    }
}