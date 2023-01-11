package com.smithshodunke.cryptoapp.presentation.ui.coinlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.smithshodunke.cryptoapp.presentation.components.CoinListItem
import com.smithshodunke.cryptoapp.presentation.components.LoadingState

@Composable
fun CoinListScreen(
    viewModel: CoinListViewModel,
    navigateToCoinInfoScreen: (coinInfoId: String) -> Unit
) {
    val viewState = viewModel.viewState.value

    CoinListScreen(
        state = viewState,
        navigateToCoinInfoScreen = { coinInfoId ->
            navigateToCoinInfoScreen(coinInfoId)
        },
        recallApi = { viewModel.recallApi() }
    )
}

@Composable
fun CoinListScreen(
    state: CoinListViewState,
    navigateToCoinInfoScreen: (coinInfoId: String) -> Unit,
    recallApi: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        if (state.isLoading) {
            LoadingState()
        }
        if (state.error.isNullOrBlank()) {
            LazyColumn {
                items(state.coinList) { cryptoCoin ->
                    CoinListItem(
                        coin = cryptoCoin,
                        onClick = { coinId ->
                            navigateToCoinInfoScreen(coinId)
                        }
                    )
                    Divider(color = Color.Black)
                }
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = state.error,
                    color = Color.Red,
                )
                Button(onClick = { recallApi() }) {
                    Text(text = "Retry")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCoinListScreen() {
    CoinListScreen(
        state = CoinListViewState(),
        navigateToCoinInfoScreen = {},
        recallApi = {}
    )
}