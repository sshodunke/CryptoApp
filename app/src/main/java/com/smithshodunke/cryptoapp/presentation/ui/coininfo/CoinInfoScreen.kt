package com.smithshodunke.cryptoapp.presentation.ui.coininfo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.google.accompanist.flowlayout.FlowRow
import com.smithshodunke.cryptoapp.presentation.components.CoinInfoHeader
import com.smithshodunke.cryptoapp.presentation.components.CoinInfoTag
import com.smithshodunke.cryptoapp.presentation.components.LoadingState
import com.smithshodunke.cryptoapp.presentation.components.TeamMemberItem
import com.smithshodunke.cryptoapp.presentation.theme.MediumDimension
import com.smithshodunke.cryptoapp.presentation.theme.SmallDimension


@Composable
fun CoinInfoScreen(
    viewModel: CoinInfoViewModel
) {
    val viewState = viewModel.viewState.value

    CoinInfoScreen(
        state = viewState,
        recallApi = { viewModel.setStateEvent(CoinInfoStateEvent.RecallApi) }
    )
}

@Composable
fun CoinInfoScreen(
    state: CoinInfoViewState,
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
            state.coinInfo?.let { coinInfo ->
                LazyColumn(
                    modifier = Modifier
                        .padding(MediumDimension)
                        .fillMaxSize()
                ) {
                    item {
                        CoinInfoHeader(
                            coinInfo = coinInfo
                        )
                    }

                    item {
                        if (!coinInfo.description.isNullOrEmpty()) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(text = "Description", fontWeight = FontWeight.Bold)
                            }

                            Text(text = coinInfo.description, fontWeight = FontWeight.Light)
                            Spacer(modifier = Modifier.height(MediumDimension))
                        }
                    }

                    if (!coinInfo.tags.isNullOrEmpty()) {
                        item {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(text = "Tags", fontWeight = FontWeight.Bold)
                            }
                            Spacer(modifier = Modifier.height(SmallDimension))
                        }

                        item {
                            FlowRow(
                                crossAxisSpacing = SmallDimension,
                                mainAxisSpacing = SmallDimension
                            ) {
                                coinInfo.tags.forEach { tag ->
                                    CoinInfoTag(tag = tag.name)
                                }
                            }
                        }



                        item {
                            Spacer(modifier = Modifier.height(MediumDimension))
                        }
                    }

                    if (coinInfo.team.isNotEmpty()) {
                        item {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(text = "Team Members", fontWeight = FontWeight.Bold)
                            }
                        }

                        items(coinInfo.team) { teamMember ->
                            TeamMemberItem(teamMember = teamMember)
                            Divider(color = Color.Gray)
                        }
                    }
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