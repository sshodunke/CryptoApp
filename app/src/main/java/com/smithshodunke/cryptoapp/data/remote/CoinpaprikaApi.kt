package com.smithshodunke.cryptoapp.data.remote

import com.smithshodunke.cryptoapp.data.remote.dto.coin.CoinDto
import com.smithshodunke.cryptoapp.data.remote.dto.coininfo.CoinInfoDto
import com.smithshodunke.cryptoapp.util.Constants.GET_ALL_COINS_ENDPOINT
import com.smithshodunke.cryptoapp.util.Constants.GET_COIN_BY_ID_ENDPOINT
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinpaprikaApi {

    @GET(GET_ALL_COINS_ENDPOINT)
    suspend fun getAllCoins(): List<CoinDto>

    @GET(GET_COIN_BY_ID_ENDPOINT)
    suspend fun getCoinById(
        @Path("id") id: String
    ): CoinInfoDto
}