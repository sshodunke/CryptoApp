package com.smithshodunke.cryptoapp.domain.model.coininfo

import com.smithshodunke.cryptoapp.data.remote.dto.coininfo.*

data class CoinInfo(
    val id: String,
    val description: String,
    val isActive: Boolean,
    val logo: String,
    val name: String,
    val rank: Int,
    val symbol: String,
    val team: List<Team>,
    val tags: List<Tag>
)