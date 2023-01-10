package com.smithshodunke.cryptoapp.data.repository

import com.smithshodunke.cryptoapp.data.mappers.toCoin
import com.smithshodunke.cryptoapp.data.mappers.toCoinInfo
import com.smithshodunke.cryptoapp.data.remote.CoinpaprikaApi
import com.smithshodunke.cryptoapp.domain.model.coin.Coin
import com.smithshodunke.cryptoapp.domain.model.coininfo.CoinInfo
import com.smithshodunke.cryptoapp.domain.repository.CoinRepository
import com.smithshodunke.cryptoapp.util.Constants.GENERIC_UNKNOWN_ERROR_MSG
import com.smithshodunke.cryptoapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinpaprikaApi
) : CoinRepository {

    override suspend fun getAllCoins(): Flow<Resource<List<Coin>>> = flow {
        emit(Resource.Loading())

        try {
            val response = api.getAllCoins().map { coinDto -> coinDto.toCoin() }
            emit(Resource.Success(data = response))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Resource.Error(message = GENERIC_UNKNOWN_ERROR_MSG))
        }
    }


    override suspend fun getCoinById(id: String): Flow<Resource<CoinInfo>> = flow {
        api.getCoinById(id).toCoinInfo()
    }

}