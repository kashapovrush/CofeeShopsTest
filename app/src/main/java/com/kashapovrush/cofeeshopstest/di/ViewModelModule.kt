package com.kashapovrush.cofeeshopstest.di

import androidx.lifecycle.ViewModel
import com.kashapovrush.cofeeshopstest.presentation.ViewModel.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    @Binds
    fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel
}