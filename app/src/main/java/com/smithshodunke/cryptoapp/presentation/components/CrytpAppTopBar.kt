package com.smithshodunke.cryptoapp.presentation.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import com.smithshodunke.cryptoapp.presentation.ui.coinlist.CoinListStateEvent

@Composable
fun CryptoTopBar(
    stateEvent: (CoinListStateEvent) -> Unit
) {
    var menuExpanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "Crypto App") },
        actions = {
            IconButton(
                onClick = { menuExpanded = true }
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Open Options"
                )
            }

            DropdownMenu(
                expanded = menuExpanded,
                onDismissRequest = { menuExpanded = false }
            ) {
                DropdownMenuItem(onClick = {
                    stateEvent(CoinListStateEvent.SortBy(CoinListStateEvent.Sorting.DEFAULT))
                    menuExpanded = false
                }) {
                    Text(text = "Default")
                }
                DropdownMenuItem(onClick = {
                    stateEvent(CoinListStateEvent.SortBy(CoinListStateEvent.Sorting.ALPHABETICAL_ASC))
                    menuExpanded = false
                }) {
                    Text(text = "Alphabetical Order (ASC)")
                }
                DropdownMenuItem(onClick = {
                    stateEvent(CoinListStateEvent.SortBy(CoinListStateEvent.Sorting.ALPHABETICAL_DESC))
                    menuExpanded = false
                }) {
                    Text(text = "Alphabetical Order (DESC)")
                }
                DropdownMenuItem(onClick = {
                    stateEvent(CoinListStateEvent.SortBy(CoinListStateEvent.Sorting.RANK))
                    menuExpanded = false
                }) {
                    Text(text = "Rank")
                }
                DropdownMenuItem(onClick = {
                    stateEvent(CoinListStateEvent.SortBy(CoinListStateEvent.Sorting.RANK_EXCLUDE_INACTIVE))
                    menuExpanded = false
                }) {
                    Text(text = "Rank (Exclude Inactive)")
                }
            }

        }
    )
}