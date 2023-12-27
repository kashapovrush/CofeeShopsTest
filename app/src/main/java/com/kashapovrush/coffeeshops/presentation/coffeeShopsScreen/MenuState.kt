package com.kashapovrush.coffeeshops.presentation.coffeeShopsScreen

import com.kashapovrush.coffeeshops.data.model.MenuDto

sealed class MenuState {

    object Initial: MenuState()

    data class MenuItem(
        val items: List<MenuDto>
    ): MenuState()
}
