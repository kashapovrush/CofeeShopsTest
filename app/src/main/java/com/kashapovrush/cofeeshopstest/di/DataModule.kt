package com.kashapovrush.cofeeshopstest.di

import com.kashapovrush.cofeeshopstest.data.network.ApiFactory
import com.kashapovrush.cofeeshopstest.data.network.ApiService
import com.kashapovrush.cofeeshopstest.data.repository.RepositoryImpl
import com.kashapovrush.cofeeshopstest.domain.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(impl: RepositoryImpl): AuthRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}