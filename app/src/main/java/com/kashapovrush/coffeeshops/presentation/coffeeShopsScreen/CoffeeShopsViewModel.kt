package com.kashapovrush.coffeeshops.presentation.coffeeShopsScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kashapovrush.coffeeshops.domain.entity.Payment
import com.kashapovrush.coffeeshops.domain.coffeeShops.AddPaymentItemUseCase
import com.kashapovrush.coffeeshops.domain.coffeeShops.GetListUseCase
import com.kashapovrush.coffeeshops.domain.coffeeShops.GetLocationsUseCase
import com.kashapovrush.coffeeshops.domain.coffeeShops.GetMenuUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoffeeShopsViewModel @Inject constructor(
    private val getLocationsUseCase: GetLocationsUseCase,
    private val getMenuUseCase: GetMenuUseCase,
    private val addPaymentItemUseCase: AddPaymentItemUseCase,
    private val getListUseCase: GetListUseCase
) : ViewModel() {

    private val _stateListLocations = MutableLiveData<LocationsState>(LocationsState.Initial)
    val stateListLocation: LiveData<LocationsState> = _stateListLocations

    private val _stateMenu = MutableLiveData<MenuState>(MenuState.Initial)
    val stateMenu: LiveData<MenuState> = _stateMenu

    val paymentList = getListUseCase().asLiveData()


    fun getLocations(token: String) {
        viewModelScope.launch {
            getLocationsUseCase(token).collect {
                _stateListLocations.value = LocationsState.CoffeeShops(it)
            }
        }
    }

    fun getMenu(shop: Int, token: String) {
        viewModelScope.launch {
            getMenuUseCase(shop, token).collect {
                _stateMenu.value = MenuState.MenuItem(it)
            }
        }
    }

    fun addPaymentItem(payment: Payment) {
        viewModelScope.launch {
            addPaymentItemUseCase(payment)
        }

    }
}