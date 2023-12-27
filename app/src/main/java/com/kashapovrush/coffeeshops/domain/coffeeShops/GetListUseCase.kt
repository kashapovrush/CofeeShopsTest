package com.kashapovrush.coffeeshops.domain.coffeeShops

import com.kashapovrush.coffeeshops.domain.entity.Payment
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListUseCase @Inject constructor(private val repository: CoffeeShopsRepository) {

    operator fun invoke(): Flow<List<Payment>> {
        return repository.getListPayments()
    }
}