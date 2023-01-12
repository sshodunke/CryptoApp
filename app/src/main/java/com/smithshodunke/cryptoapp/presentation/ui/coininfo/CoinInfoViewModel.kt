package com.smithshodunke.cryptoapp.presentation.ui.coininfo

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.smithshodunke.cryptoapp.domain.repository.CoinRepository
import com.smithshodunke.cryptoapp.presentation.navigation.CryptoDestinations.COIN_INFO_ID_ARGUMENT
import com.smithshodunke.cryptoapp.presentation.util.BaseViewModel
import com.smithshodunke.cryptoapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinInfoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: CoinRepository
) : BaseViewModel<CoinInfoStateEvent, CoinInfoViewState>(
    initialState = CoinInfoViewState(
        coinId = savedStateHandle.get<String>(COIN_INFO_ID_ARGUMENT) ?: "N/A"
    )
) {

    init {
        viewModelScope.launch {
            getCoinById()
        }
    }

    override fun handleStateEvent(stateEvent: CoinInfoStateEvent) {
        when (stateEvent) {
            CoinInfoStateEvent.RecallApi -> {
                viewModelScope.launch {
                    getCoinById()
                }
            }
        }
    }

    private suspend fun getCoinById() {
        repository.getCoinById(viewState.value.coinId).collect { resource ->
            when (resource) {
                is Resource.Error -> {
                    setViewState {
                        copy(
                            isLoading = false,
                            error = resource.message
                        )
                    }
                }
                is Resource.Loading -> {
                    setViewState {
                        copy(
                            isLoading = true,
                            error = null
                        )
                    }
                }
                is Resource.Success -> {
                    setViewState {
                        copy(
                            isLoading = false,
                            coinInfo = resource.data,
                            error = null
                        )
                    }
                }
            }
        }
    }
}