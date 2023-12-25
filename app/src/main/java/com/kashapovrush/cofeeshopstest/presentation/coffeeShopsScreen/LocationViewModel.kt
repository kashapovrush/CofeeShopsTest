package com.kashapovrush.cofeeshopstest.presentation.coffeeShopsScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kashapovrush.cofeeshopstest.data.model.Location
import com.kashapovrush.cofeeshopstest.data.model.Menu
import com.kashapovrush.cofeeshopstest.domain.coffeeShops.GetLocationsUseCase
import com.kashapovrush.cofeeshopstest.domain.coffeeShops.GetMenuUseCase
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LocationViewModel @Inject constructor(
    private val getLocationsUseCase: GetLocationsUseCase,
    private val getMenuUseCase: GetMenuUseCase
) : ViewModel() {

    private val _stateListLocations = MutableLiveData<LocationsState>(LocationsState.Initial)
    val stateListLocation: LiveData<LocationsState> = _stateListLocations

    private val _stateMenu = MutableLiveData<MenuState>(MenuState.Initial)
    val stateMenu: LiveData<MenuState> = _stateMenu


    fun getLocations(token: String) {
        viewModelScope.launch {
            getLocationsUseCase(token).enqueue(object : Callback<List<Location>> {
                override fun onResponse(
                    call: Call<List<Location>>,
                    response: Response<List<Location>>
                ) {

                    _stateListLocations.value = LocationsState.CoffeeShops(
                        response.body() ?: listOf()
                    )
                }

                override fun onFailure(call: Call<List<Location>>, t: Throwable) {

                }

            })
        }
    }

    fun getMenu(shop: Int, token: String) {
        viewModelScope.launch {
            getMenuUseCase(shop, token).enqueue(object : Callback<List<Menu>> {
                override fun onResponse(call: Call<List<Menu>>, response: Response<List<Menu>>) {
                    _stateMenu.value = MenuState.MenuItem(
                        response.body() ?: listOf()
                    )
                }

                override fun onFailure(call: Call<List<Menu>>, t: Throwable) {
                }

            })
        }
    }
}