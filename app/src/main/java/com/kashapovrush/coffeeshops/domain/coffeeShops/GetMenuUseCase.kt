package com.kashapovrush.coffeeshops.domain.coffeeShops

import com.kashapovrush.coffeeshops.data.model.MenuDto
import com.kashapovrush.coffeeshops.domain.entity.Menu
import retrofit2.Call
import javax.inject.Inject

class GetMenuUseCase @Inject constructor(private val repository: CoffeeShopsRepository) {

    suspend operator fun  invoke(shop: Int, token: String): Call<List<MenuDto>> {
        return repository.getMenu(shop, token)
    }
}