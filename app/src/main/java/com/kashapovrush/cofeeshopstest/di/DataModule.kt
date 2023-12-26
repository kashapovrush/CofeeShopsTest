package com.kashapovrush.cofeeshopstest.di

import android.app.Application
import com.kashapovrush.cofeeshopstest.data.database.AppDatabase
import com.kashapovrush.cofeeshopstest.data.database.PaymentDao
import com.kashapovrush.cofeeshopstest.data.network.ApiFactory
import com.kashapovrush.cofeeshopstest.data.network.ApiService
import com.kashapovrush.cofeeshopstest.data.repository.AuthRepositoryImpl
import com.kashapovrush.cofeeshopstest.data.repository.CoffeeShopsRepositoryImpl
import com.kashapovrush.cofeeshopstest.domain.auth.AuthRepository
import com.kashapovrush.cofeeshopstest.domain.coffeeShops.CoffeeShopsRepository
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