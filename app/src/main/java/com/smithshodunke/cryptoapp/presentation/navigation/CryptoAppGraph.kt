package com.smithshodunke.cryptoapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.smithshodunke.cryptoapp.presentation.navigation.CryptoDestinations.COIN_INFO_ID_ARGUMENT
import com.smithshodunke.cryptoapp.presentation.ui.coininfo.CoinInfoScreen
import com.smithshodunke.cryptoapp.presentation.ui.coinlist.CoinListScreen
import com.smithshodunke.cryptoapp.presentation.ui.coinlist.CoinListViewModel

@Composable
fun CryptoAppGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = CryptoDestinations.COIN_LIST_GRAPH_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(
            route = CryptoDestinations.COIN_LIST_GRAPH_ROUTE
        ) {
            val viewModel: CoinListViewModel = hiltViewModel()
            CoinListScreen(
                viewModel,
                navigateToCoinInfoScreen = { coinId ->
                    CryptoNavigationActions(navController).navigateToCoinInfo(coinId)
                }
            )
        }
        composable(
            route = CryptoDestinations.COIN_INFO_GRAPH_ROUTE,
            arguments = listOf(
                navArgument(COIN_INFO_ID_ARGUMENT) { type = NavType.StringType }
            )
        ) {
            CoinInfoScreen()
        }
    }
}