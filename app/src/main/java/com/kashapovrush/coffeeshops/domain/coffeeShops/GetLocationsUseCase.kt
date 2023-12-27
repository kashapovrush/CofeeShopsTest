package com.kashapovrush.coffeeshops.domain.coffeeShops

import com.kashapovrush.coffeeshops.domain.entity.Location
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocationsUseCase @Inject constructor(private val repository: CoffeeShopsRepository) {

    operator fun invoke(token: String): Flow<List<Location>> {
        return repository.getLocations(token)
    }
}