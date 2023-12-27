package com.kashapovrush.coffeeshops.data.mapper

import com.kashapovrush.coffeeshops.data.database.PaymentDb
import com.kashapovrush.coffeeshops.domain.Payment
import javax.inject.Inject

class CoffeeShopsMapper @Inject constructor() {


    fun mapPaymentToDbModel(payment: Payment): PaymentDb {
        return PaymentDb(
            id = payment.id,
            name = payment.name,
            count = payment.count,
            price = payment.price
        )
    }

    fun mapPaymentDbToEntity(payment: PaymentDb): Payment {
        return Payment(
            id = payment.id,
            name = payment.name,
            count = payment.count,
            price = payment.price
        )
    }



    fun mapListDbModelToListEntity(list: List<PaymentDb>): List<Payment> {
        return list.map {
            mapPaymentDbToEntity(it)
        }
    }
}