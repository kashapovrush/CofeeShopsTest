package com.kashapovrush.coffeeshops.data.mapper

import com.kashapovrush.coffeeshops.data.database.PaymentDb
import com.kashapovrush.coffeeshops.data.model.LocationDto
import com.kashapovrush.coffeeshops.data.model.MenuDto
import com.kashapovrush.coffeeshops.data.model.TokenDto
import com.kashapovrush.coffeeshops.data.model.UserDto
import com.kashapovrush.coffeeshops.domain.entity.Location
import com.kashapovrush.coffeeshops.domain.entity.Menu
import com.kashapovrush.coffeeshops.domain.entity.Payment
import com.kashapovrush.coffeeshops.domain.entity.Token
import com.kashapovrush.coffeeshops.domain.entity.User
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

    fun mapLocationListDtoToListEntity(locations: List<LocationDto>): List<Location> {
        val result = mutableListOf<Location>()
        locations.forEach {
            result.add(
                Location(
                    id = it.id,
                    name = it.name,
                    latitude = it.pointDto.latitude,
                    longitude = it.pointDto.longitude
                )
            )
        }

        return result
    }

    fun mapMenuListDtoToListEntity(items: List<MenuDto>): List<Menu> {
        val result = mutableListOf<Menu>()
        items.forEach {
            result.add(
                Menu(
                    id = it.id,
                    name = it.name,
                    imageUrl = it.imageUrl,
                    price = it.price
                )
            )
        }

        return result
    }
}