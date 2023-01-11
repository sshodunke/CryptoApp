package com.smithshodunke.cryptoapp.presentation.ui.coininfo

import androidx.lifecycle.SavedStateHandle
import com.smithshodunke.cryptoapp.presentation.util.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinInfoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): BaseViewModel<CoinInfoViewState>(
    CoinInfoViewState(
        coinId = savedStateHandle.get<String>("") ?: "N/A"
    )
) {
}