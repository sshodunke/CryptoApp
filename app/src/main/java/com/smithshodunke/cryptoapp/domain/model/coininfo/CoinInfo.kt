package com.smithshodunke.cryptoapp.domain.model.coininfo

import com.smithshodunke.cryptoapp.data.remote.dto.coininfo.*

data class CoinInfo(
    val id: String,
    val description: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val lastDataAt: String,
    val links: Links,
    val logo: String,
    val message: String,
    val name: String,
    val rank: Int,
    val symbol: String,
    val team: List<Team>,
    val type: String,
)