package com.rainforest.app.di

import com.rainforest.app.network.ApiService
import com.rainforest.app.network.RetrofitInstance
import com.rainforest.app.repository.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return RetrofitInstance.api
    }

    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService): ItemRepository {
        return ItemRepository(apiService)
    }
}