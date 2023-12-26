package com.kashapovrush.cofeeshopstest.data.repository

import com.kashapovrush.cofeeshopstest.data.database.PaymentDao
import com.kashapovrush.cofeeshopstest.data.mapper.CoffeeShopsMapper
import com.kashapovrush.cofeeshopstest.data.model.Location
import com.kashapovrush.cofeeshopstest.data.model.Menu
import com.kashapovrush.cofeeshopstest.data.network.ApiService
import com.kashapovrush.cofeeshopstest.domain.Payment
import com.kashapovrush.cofeeshopstest.domain.coffeeShops.CoffeeShopsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Call
import javax.inject.Inject

class CoffeeShopsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val paymentDao: PaymentDao,
    private val mapper: CoffeeShopsMapper
) : CoffeeShopsRepository {

    private val _list = mutableListOf<Payment>()
    val list: List<Payment> = _list


    override suspend fun getLocations(token: String): Call<List<Location>> {
        return apiService.getLocations(token)
    }

    override suspend fun getMenu(shop: Int, token: String): Call<List<Menu>> {
        return apiService.getMenu(shop, token)
    }

    override suspend fun addPaymentItem(payment: Payment) {
        paymentDao.addPaymentItem(mapper.mapPaymentToDbModel(payment))
    }

    override fun getListPayments(): Flow<List<Payment>> {
        return paymentDao.getList()
            .map {
            mapper.mapListDbModelToListEntity(it)
        }
    }
}


