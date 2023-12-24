package com.kashapovrush.cofeeshopstest.di

import com.kashapovrush.cofeeshopstest.data.network.ApiFactory
import com.kashapovrush.cofeeshopstest.data.network.ApiService
import com.kashapovrush.cofeeshopstest.data.repository.AuthRepositoryImpl
import com.kashapovrush.cofeeshopstest.data.repository.LocationRepositoryImpl
import com.kashapovrush.cofeeshopstest.domain.auth.AuthRepository
import com.kashapovrush.cofeeshopstest.domain.location.LocationRepository
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
    fun bindLocationsRepository(impl: LocationRepositoryImpl): LocationRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}