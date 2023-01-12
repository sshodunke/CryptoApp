package com.smithshodunke.cryptoapp.presentation.ui.coinlist

import androidx.lifecycle.viewModelScope
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

    override fun handleStateEvent(stateEvent: CoinListStateEvent) {
        when(stateEvent) {
            CoinListStateEvent.RecallApi -> {
                viewModelScope.launch {
                    getAllCoins()
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