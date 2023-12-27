package com.kashapovrush.coffeeshops.domain.coffeeShops

import com.kashapovrush.coffeeshops.data.model.LocationDto
import com.kashapovrush.coffeeshops.domain.entity.Location
import retrofit2.Call
import javax.inject.Inject

class GetLocationsUseCase @Inject constructor(private val repository: CoffeeShopsRepository) {

    suspend operator fun invoke(token: String): Call<List<LocationDto>> {
        return repository.getLocations(token)
    }
}