package com.gamevault.gamedetail.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gamevault.gamedetail.domain.model.GameDetail
import com.gamevault.gamedetail.domain.usecase.FetchGameDetailUseCase
import com.gamevault.gamedetail.domain.usecase.GetGameDetailUseCase
import com.gamevault.gamedetail.domain.usecase.ToggleDetailFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class GameDetailUiState(
    val gameDetail: GameDetail? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class GameDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getGameDetailUseCase: GetGameDetailUseCase,
    private val fetchGameDetailUseCase: FetchGameDetailUseCase,
    private val toggleFavoriteUseCase: ToggleDetailFavoriteUseCase
) : ViewModel() {

    private val gameId: Int = checkNotNull(savedStateHandle["gameId"])

    private val _uiState = MutableStateFlow(GameDetailUiState())
    val uiState: StateFlow<GameDetailUiState> = _uiState.asStateFlow()

    init {
        observeDetail()
        fetchDetail()
    }

    fun onToggleFavorite() {
        val current = _uiState.value.gameDetail ?: return
        viewModelScope.launch {
            toggleFavoriteUseCase(gameId, !current.isFavorite)
        }
    }

    private fun observeDetail() {
        getGameDetailUseCase(gameId)
            .onEach { detail ->
                _uiState.update { it.copy(gameDetail = detail) }
            }
            .launchIn(viewModelScope)
    }

    private fun fetchDetail() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                fetchGameDetailUseCase(gameId)
            } catch (e: Exception) {
                _uiState.update { it.copy(error = e.message) }
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }
}
