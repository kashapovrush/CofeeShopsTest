package com.kashapovrush.cofeeshopstest.domain.location

import com.kashapovrush.cofeeshopstest.data.model.Location
import com.kashapovrush.cofeeshopstest.data.model.Menu
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call

interface LocationRepository {

    suspend fun getLocations(token: String): Call<List<Location>>

    suspend fun getMenu(shop: Int, token: String): Call<List<Menu>>
}