package com.kashapovrush.coffeeshops.presentation.coffeeShopsScreen

import com.kashapovrush.coffeeshops.domain.entity.Menu

sealed class MenuState {

    object Initial: MenuState()

    data class MenuItem(
        val items: List<Menu>
    ): MenuState()
}
