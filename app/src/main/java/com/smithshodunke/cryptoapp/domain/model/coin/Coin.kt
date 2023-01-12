package com.smithshodunke.cryptoapp.domain.model.coin

data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)