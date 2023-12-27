package com.kashapovrush.coffeeshops.presentation.coffeeShopsScreen

import com.kashapovrush.coffeeshops.domain.entity.Location

sealed class LocationsState {


    object Initial: LocationsState()

    data class CoffeeShops(
        val locations: List<Location>
    ): LocationsState()
}
