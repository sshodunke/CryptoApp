package com.smithshodunke.cryptoapp.data.mappers

import com.smithshodunke.cryptoapp.data.remote.dto.coin.CoinDto
import com.smithshodunke.cryptoapp.data.remote.dto.coininfo.CoinInfoDto
import com.smithshodunke.cryptoapp.domain.model.coin.Coin
import com.smithshodunke.cryptoapp.domain.model.coininfo.CoinInfo

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = this.id,
        isActive = this.is_active,
        name = this.name,
        rank = this.rank,
        symbol = this.symbol,
    )
}

fun CoinInfoDto.toCoinInfo(): CoinInfo {
    return CoinInfo(
        id = this.id,
        description = this.description,
        isActive = this.is_active,
        logo = this.logo,
        name = this.name,
        rank = this.rank,
        symbol = this.symbol,
        team = this.team,
        tags = this.tags
    )
}