package com.kashapovrush.cofeeshopstest.domain.coffeeShops

import com.kashapovrush.cofeeshopstest.data.model.Location
import retrofit2.Call
import javax.inject.Inject

class GetLocationsUseCase @Inject constructor(private val repository: CoffeeShopsRepository) {

    suspend operator fun invoke(token: String): Call<List<Location>> {
        return repository.getLocations(token)
    }
}