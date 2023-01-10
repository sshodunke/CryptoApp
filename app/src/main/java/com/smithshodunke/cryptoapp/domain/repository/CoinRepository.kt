package com.smithshodunke.cryptoapp.domain.repository

import com.smithshodunke.cryptoapp.domain.model.coin.Coin
import com.smithshodunke.cryptoapp.domain.model.coininfo.CoinInfo
import com.smithshodunke.cryptoapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    /**
     * Returns a list of crypto coins
     */
    suspend fun getAllCoins(): Flow<Resource<List<Coin>>>

    /**
     * Returns information on a specific coin by the specified id
     */
    suspend fun getCoinById(id: String): Flow<Resource<CoinInfo>>
}