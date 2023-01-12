package com.smithshodunke.cryptoapp.presentation.ui.coinlist

import androidx.lifecycle.viewModelScope
import com.smithshodunke.cryptoapp.domain.model.coin.Coin
import com.smithshodunke.cryptoapp.domain.repository.CoinRepository
import com.smithshodunke.cryptoapp.presentation.util.BaseViewModel
import com.smithshodunke.cryptoapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val repository: CoinRepository
) : BaseViewModel<CoinListStateEvent, CoinListViewState>(
    initialState = CoinListViewState()
) {
    init {
        viewModelScope.launch {
            getAllCoins()
        }
    }

    private val coinListCache: MutableList<Coin> = mutableListOf()

    override fun handleStateEvent(stateEvent: CoinListStateEvent) {
        when (stateEvent) {
            CoinListStateEvent.RecallApi -> {
                viewModelScope.launch {
                    getAllCoins()
                }
            }
            is CoinListStateEvent.SortBy -> {
                when (stateEvent.sort) {
                    CoinListStateEvent.Sorting.ALPHABETICAL_ASC -> {
                        setViewState {
                            copy(
                                coinList = coinListCache.sortedBy { it.name.trim() }
                            )
                        }
                    }
                    CoinListStateEvent.Sorting.ALPHABETICAL_DESC -> {
                        setViewState {
                            copy(
                                coinList = coinListCache.sortedByDescending { it.name.trim() }
                            )
                        }
                    }
                    CoinListStateEvent.Sorting.RANK -> {
                        setViewState {
                            copy(
                                coinList = coinListCache.sortedBy { it.rank }
                            )
                        }
                    }
                    CoinListStateEvent.Sorting.DEFAULT -> {
                        setViewState {
                            copy(
                                coinList = coinListCache
                            )
                        }
                    }
                    CoinListStateEvent.Sorting.RANK_EXCLUDE_INACTIVE -> {
                        setViewState {
                            copy(
                                coinList = coinListCache
                                    .filter { it.isActive }
                                    .sortedBy { it.rank }
                            )
                        }
                    }
                }
            }
        }
    }

    private suspend fun getAllCoins() {
        repository.getAllCoins().collect { resource ->
            when (resource) {
                is Resource.Error -> {
                    setViewState { CoinListViewState(error = resource.message) }
                }
                is Resource.Loading -> {
                    setViewState { copy(isLoading = true, error = null) }
                }
                is Resource.Success -> {
                    coinListCache.addAll(resource.data ?: listOf())
                    setViewState {
                        copy(
                            isLoading = false,
                            coinList = resource.data ?: listOf()
                        )
                    }
                }
            }
        }
    }
}