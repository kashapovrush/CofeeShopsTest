package com.kashapovrush.cofeeshopstest.presentation.coffeeShopsScreen

import com.kashapovrush.cofeeshopstest.data.model.Menu

sealed class MenuState {

    object Initial: MenuState()

    data class MenuItem(
        val items: List<Menu>
    ): MenuState()
}
