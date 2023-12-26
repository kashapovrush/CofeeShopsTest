package com.kashapovrush.cofeeshopstest.domain.coffeeShops

import com.kashapovrush.cofeeshopstest.domain.Payment
import javax.inject.Inject

class AddPaymentItemUseCase @Inject constructor(private val repository: CoffeeShopsRepository) {

    suspend operator fun invoke(payment: Payment) {
        repository.addPaymentItem(payment)
    }
}