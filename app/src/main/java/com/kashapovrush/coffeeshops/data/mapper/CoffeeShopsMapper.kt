package com.kashapovrush.coffeeshops.data.mapper

import com.kashapovrush.coffeeshops.data.database.PaymentDb
import com.kashapovrush.coffeeshops.data.model.TokenDto
import com.kashapovrush.coffeeshops.data.model.UserDto
import com.kashapovrush.coffeeshops.domain.entity.Payment
import com.kashapovrush.coffeeshops.domain.entity.Token
import com.kashapovrush.coffeeshops.domain.entity.User
import retrofit2.Call
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

    fun mapTokenDtoToEntity(tokenDto: TokenDto): Token {
        return Token(
            token = tokenDto.token,
            lifeTime = tokenDto.lifeTime
        )
    }

    fun mapUserToDto(user: User): UserDto {
        return UserDto(
            login = user.login,
            password = user.password
        )
    }
}