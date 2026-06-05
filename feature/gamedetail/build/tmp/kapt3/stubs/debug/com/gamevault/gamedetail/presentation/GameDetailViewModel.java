package com.gamevault.gamedetail.presentation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0006\u0010\u0017\u001a\u00020\u0015R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/gamevault/gamedetail/presentation/GameDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "getGameDetailUseCase", "Lcom/gamevault/gamedetail/domain/usecase/GetGameDetailUseCase;", "fetchGameDetailUseCase", "Lcom/gamevault/gamedetail/domain/usecase/FetchGameDetailUseCase;", "toggleFavoriteUseCase", "Lcom/gamevault/gamedetail/domain/usecase/ToggleDetailFavoriteUseCase;", "(Landroidx/lifecycle/SavedStateHandle;Lcom/gamevault/gamedetail/domain/usecase/GetGameDetailUseCase;Lcom/gamevault/gamedetail/domain/usecase/FetchGameDetailUseCase;Lcom/gamevault/gamedetail/domain/usecase/ToggleDetailFavoriteUseCase;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/gamevault/gamedetail/presentation/GameDetailUiState;", "gameId", "", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "fetchDetail", "", "observeDetail", "onToggleFavorite", "gamedetail_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class GameDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.gamevault.gamedetail.domain.usecase.GetGameDetailUseCase getGameDetailUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gamevault.gamedetail.domain.usecase.FetchGameDetailUseCase fetchGameDetailUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gamevault.gamedetail.domain.usecase.ToggleDetailFavoriteUseCase toggleFavoriteUseCase = null;
    private final int gameId = 0;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.gamevault.gamedetail.presentation.GameDetailUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.gamevault.gamedetail.presentation.GameDetailUiState> uiState = null;
    
    @javax.inject.Inject()
    public GameDetailViewModel(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle, @org.jetbrains.annotations.NotNull()
    com.gamevault.gamedetail.domain.usecase.GetGameDetailUseCase getGameDetailUseCase, @org.jetbrains.annotations.NotNull()
    com.gamevault.gamedetail.domain.usecase.FetchGameDetailUseCase fetchGameDetailUseCase, @org.jetbrains.annotations.NotNull()
    com.gamevault.gamedetail.domain.usecase.ToggleDetailFavoriteUseCase toggleFavoriteUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.gamevault.gamedetail.presentation.GameDetailUiState> getUiState() {
        return null;
    }
    
    public final void onToggleFavorite() {
    }
    
    private final void observeDetail() {
    }
    
    private final void fetchDetail() {
    }
}