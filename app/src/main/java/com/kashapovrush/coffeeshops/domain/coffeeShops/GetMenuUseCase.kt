package com.kashapovrush.coffeeshops.domain.coffeeShops

import com.kashapovrush.coffeeshops.domain.entity.Menu
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMenuUseCase @Inject constructor(private val repository: CoffeeShopsRepository) {

    suspend operator fun  invoke(shop: Int, token: String): Flow<List<Menu>> {
        return repository.getMenu(shop, token)
    }
}