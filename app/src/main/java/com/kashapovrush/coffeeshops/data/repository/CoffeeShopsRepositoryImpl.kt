package com.kashapovrush.coffeeshops.data.repository

import com.kashapovrush.coffeeshops.data.database.PaymentDao
import com.kashapovrush.coffeeshops.data.mapper.CoffeeShopsMapper
import com.kashapovrush.coffeeshops.data.network.ApiService
import com.kashapovrush.coffeeshops.domain.entity.Payment
import com.kashapovrush.coffeeshops.domain.coffeeShops.CoffeeShopsRepository
import com.kashapovrush.coffeeshops.domain.entity.Location
import com.kashapovrush.coffeeshops.domain.entity.Menu
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class CoffeeShopsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val paymentDao: PaymentDao,
    private val mapper: CoffeeShopsMapper
) : CoffeeShopsRepository {

    private val _list = mutableListOf<Payment>()
    val list: List<Payment> = _list

    val coroutineScope = CoroutineScope(Dispatchers.Default)


    override fun getLocations(token: String): Flow<List<Location>> = flow {
        emit(apiService.getLocations(token))
    }.map {
        mapper.mapLocationListDtoToListEntity(it)
    }.catch { }

    override fun getMenu(shop: Int, token: String): Flow<List<Menu>> = flow {
        emit(apiService.getMenu(shop, token))
    }.map {
        mapper.mapMenuListDtoToListEntity(it)
    }

    override suspend fun addPaymentItem(payment: Payment) {
        paymentDao.addPaymentItem(mapper.mapPaymentToDbModel(payment))
    }

    override fun getListPayments(): StateFlow<List<Payment>> = flow {
        emit(paymentDao.getList())
    }
        .map {
            mapper.mapListDbModelToListEntity(it)
        }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.Lazily,
            initialValue = listOf()
        )

}
