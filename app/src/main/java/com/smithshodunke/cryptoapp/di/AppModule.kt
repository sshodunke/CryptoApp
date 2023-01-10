package com.smithshodunke.cryptoapp.di

import com.smithshodunke.cryptoapp.data.remote.CoinpaprikaApi
import com.smithshodunke.cryptoapp.data.repository.CoinRepositoryImpl
import com.smithshodunke.cryptoapp.domain.repository.CoinRepository
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
    fun provideCoinRepository(api: CoinpaprikaApi) : CoinRepository {
        return CoinRepositoryImpl(
            api = api
        )
    }
}