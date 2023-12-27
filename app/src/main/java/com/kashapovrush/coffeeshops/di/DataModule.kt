package com.kashapovrush.coffeeshops.di

import android.app.Application
import com.kashapovrush.coffeeshops.data.database.AppDatabase
import com.kashapovrush.coffeeshops.data.database.PaymentDao
import com.kashapovrush.coffeeshops.data.network.ApiFactory
import com.kashapovrush.coffeeshops.data.network.ApiService
import com.kashapovrush.coffeeshops.data.repository.AuthRepositoryImpl
import com.kashapovrush.coffeeshops.data.repository.CoffeeShopsRepositoryImpl
import com.kashapovrush.coffeeshops.domain.auth.AuthRepository
import com.kashapovrush.coffeeshops.domain.coffeeShops.CoffeeShopsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository

    @ApplicationScope
    @Binds
    fun bindLocationsRepository(impl: CoffeeShopsRepositoryImpl): CoffeeShopsRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

        @ApplicationScope
        @Provides
        fun providePaymentDao(application: Application): PaymentDao {
            return AppDatabase.getInstance(application).paymentDao()
        }
    }
}