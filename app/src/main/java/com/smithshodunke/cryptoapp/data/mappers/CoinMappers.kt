package com.smithshodunke.cryptoapp.data.mappers

import com.smithshodunke.cryptoapp.data.remote.dto.coin.CoinDto
import com.smithshodunke.cryptoapp.data.remote.dto.coininfo.CoinInfoDto
import com.smithshodunke.cryptoapp.domain.model.coin.Coin
import com.smithshodunke.cryptoapp.domain.model.coininfo.CoinInfo

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = this.id,
        isActive = this.is_active,
        isNew = this.is_new,
        name = this.name,
        rank = this.rank,
        symbol = this.symbol,
        type = this.type
    )
}

fun CoinInfoDto.toCoinInfo(): CoinInfo {
    return CoinInfo(
        id = this.id,
        description = this.description,
        isActive = this.is_active,
        isNew = this.is_new,
        lastDataAt = this.last_data_at,
        links = this.links,
        logo = this.logo,
        message = this.message,
        name = this.name,
        rank = this.rank,
        symbol = this.symbol,
        team = this.team,
        type = this.type
    )
}