package com.kashapovrush.coffeeshops.presentation.coffeeShopsScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kashapovrush.coffeeshops.data.model.LocationDto
import com.kashapovrush.coffeeshops.data.model.MenuDto
import com.kashapovrush.coffeeshops.domain.entity.Payment
import com.kashapovrush.coffeeshops.domain.coffeeShops.AddPaymentItemUseCase
import com.kashapovrush.coffeeshops.domain.coffeeShops.GetListUseCase
import com.kashapovrush.coffeeshops.domain.coffeeShops.GetLocationsUseCase
import com.kashapovrush.coffeeshops.domain.coffeeShops.GetMenuUseCase
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LocationViewModel @Inject constructor(
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
            getLocationsUseCase(token).enqueue(object : Callback<List<LocationDto>> {
                override fun onResponse(
                    call: Call<List<LocationDto>>,
                    response: Response<List<LocationDto>>
                ) {

                    _stateListLocations.value = LocationsState.CoffeeShops(
                        response.body() ?: listOf()
                    )
                }

                override fun onFailure(call: Call<List<LocationDto>>, t: Throwable) {

                }

            })
        }
    }

    fun getMenu(shop: Int, token: String) {
        viewModelScope.launch {
            getMenuUseCase(shop, token).enqueue(object : Callback<List<MenuDto>> {
                override fun onResponse(call: Call<List<MenuDto>>, response: Response<List<MenuDto>>) {
                    _stateMenu.value = MenuState.MenuItem(
                        response.body() ?: listOf()
                    )
                }

                override fun onFailure(call: Call<List<MenuDto>>, t: Throwable) {
                }

            })
        }
    }

    fun addPaymentItem(payment: Payment) {
        viewModelScope.launch {
            addPaymentItemUseCase(payment)
        }

    }
}