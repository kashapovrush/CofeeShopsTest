package com.kashapovrush.coffeeshops.di

import androidx.lifecycle.ViewModel
import com.kashapovrush.coffeeshops.presentation.authScreen.AuthViewModel
import com.kashapovrush.coffeeshops.presentation.coffeeShopsScreen.CoffeeShopsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    @Binds
    fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel

    @IntoMap
    @ViewModelKey(CoffeeShopsViewModel::class)
    @Binds
    fun bindLocationViewModel(viewModel: CoffeeShopsViewModel): ViewModel
}