package com.swolf.greatchase.feature.stats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swolf.greatchase.repository.PlayerDataResult
import com.swolf.greatchase.repository.StatsRepository
import com.swolf.greatchase.repository.StatsRepositoryImpl
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class StatsViewModel(private val statsRepository: StatsRepository = StatsRepositoryImpl()) :
  ViewModel() {
  val stateFlow: StateFlow<StatsUiState> =
    statsRepository
      .getPlayerStats()
      .map<PlayerDataResult, StatsUiState> { StatsUiState.Success(it) }
      .catch { emit(StatsUiState.Error) }
      .onStart { emit(StatsUiState.Loading) }
      .stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = StatsUiState.Loading,
      )
}

sealed interface StatsUiState {

  data class Success(val playerResult: PlayerDataResult? = null) : StatsUiState

  data object Loading : StatsUiState

  data object Error : StatsUiState
}
