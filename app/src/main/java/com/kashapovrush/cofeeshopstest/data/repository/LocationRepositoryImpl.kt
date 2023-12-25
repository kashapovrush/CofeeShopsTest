package com.kashapovrush.cofeeshopstest.data.repository

import com.kashapovrush.cofeeshopstest.data.model.Location
import com.kashapovrush.cofeeshopstest.data.model.Menu
import com.kashapovrush.cofeeshopstest.data.network.ApiService
import com.kashapovrush.cofeeshopstest.domain.Payment
import com.kashapovrush.cofeeshopstest.domain.location.LocationRepository
import retrofit2.Call
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : LocationRepository {

    private val _list = mutableListOf<Payment>()
    val list: List<Payment> = _list


    override suspend fun getLocations(token: String): Call<List<Location>> {
        return apiService.getLocations(token)
    }

    override suspend fun getMenu(shop: Int, token: String): Call<List<Menu>> {
        return apiService.getMenu(shop, token)
    }
}


