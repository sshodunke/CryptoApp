package com.smithshodunke.cryptoapp.di

import com.smithshodunke.cryptoapp.data.remote.CoinpaprikaApi
import com.smithshodunke.cryptoapp.util.Constants.BASE_URL
import com.smithshodunke.cryptoapp.util.HttpLoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideCoinpaprikaApi(retrofit: Retrofit): CoinpaprikaApi {
        return retrofit.create(CoinpaprikaApi::class.java)
    }
}