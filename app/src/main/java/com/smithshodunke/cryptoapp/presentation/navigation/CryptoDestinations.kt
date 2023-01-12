package com.smithshodunke.cryptoapp.presentation.navigation

import androidx.navigation.NavController
import com.smithshodunke.cryptoapp.presentation.navigation.CryptoDestinations.COIN_INFO_BASE_ROUTE

object CryptoDestinations {
    const val COIN_LIST_GRAPH_ROUTE = "route_coin_list"

    const val COIN_INFO_BASE_ROUTE = "route_coin_info"
    const val COIN_INFO_GRAPH_ROUTE = "${COIN_INFO_BASE_ROUTE}/{coinId}"

    const val COIN_INFO_ID_ARGUMENT = "coinId"
}

class CryptoNavigationActions(private val navController: NavController) {

    val navigateToCoinInfo: (coinId: String) -> Unit = { coinId ->
        navController.navigate("$COIN_INFO_BASE_ROUTE/$coinId") {

        }
    }

    val navigateToCoinList: () -> Unit = {
        navController.navigate(CryptoDestinations.COIN_LIST_GRAPH_ROUTE) {

        }
    }
}