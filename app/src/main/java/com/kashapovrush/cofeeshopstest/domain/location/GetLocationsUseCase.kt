package com.kashapovrush.cofeeshopstest.domain.location

import com.kashapovrush.cofeeshopstest.data.model.Location
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import javax.inject.Inject

class GetLocationsUseCase @Inject constructor(private val repository: LocationRepository) {

    suspend operator fun invoke(token: String): Call<List<Location>> {
        return repository.getLocations(token)
    }
}