package com.gamevault.discover.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gamevault.discover.domain.model.DiscoverSection
import com.gamevault.discover.domain.repository.DiscoverRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DiscoverUiState(
    val sections: List<DiscoverSection> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val repository: DiscoverRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DiscoverUiState())
    val uiState: StateFlow<DiscoverUiState> = _uiState.asStateFlow()

    init { loadAll() }

    fun refresh() {
        _uiState.update { it.copy(sections = emptyList()) }
        loadAll()
    }

    private fun loadAll() {
        viewModelScope.launch {
            _uiState.update { state -> state.copy(isLoading = true, error = null) }
            try {
                val newPC    = async { repository.getNewOnPC() }
                val popular  = async { repository.getPopular() }
                val newR     = async { repository.getNewReleases() }
                val upcoming = async { repository.getUpcoming() }
                val steam    = async { repository.getTopOnSteam() }
                val epic     = async { repository.getTopOnEpic() }
                val ps       = async { repository.getTopOnPS() }
                val xbox     = async { repository.getTopOnXbox() }

                addSection("🆕 Новое в Steam & Epic (PC)", newPC.await())
                addSection("🔥 Популярное", popular.await())
                addSection("📅 Свежие релизы", newR.await())
                addSection("🗓️ Скоро выйдет", upcoming.await())
                addSection("🖥️ Топ в Steam", steam.await())
                addSection("⚡ Топ в Epic Games", epic.await())
                addSection("🎮 Топ на PlayStation", ps.await())
                addSection("🟢 Топ Xbox / Game Pass", xbox.await())

            } catch (e: Exception) {
                _uiState.update { state -> state.copy(error = e.message) }
            } finally {
                _uiState.update { state -> state.copy(isLoading = false) }
            }
        }
    }

    private fun addSection(title: String, games: List<com.gamevault.discover.domain.model.DiscoverGame>) {
        if (games.isNotEmpty()) {
            _uiState.update { state ->
                state.copy(sections = state.sections + DiscoverSection(title, "", games))
            }
        }
    }
}
