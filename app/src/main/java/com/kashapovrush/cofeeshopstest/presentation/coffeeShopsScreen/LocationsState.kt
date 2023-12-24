package com.kashapovrush.cofeeshopstest.presentation.coffeeShopsScreen

import com.kashapovrush.cofeeshopstest.data.model.Location

sealed class LocationsState {


    object Initial: LocationsState()

    data class CoffeeShops(
        val locations: List<Location>
    ): LocationsState()
}
