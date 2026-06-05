package com.gamevault.discover.presentation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\u0006\u0010\u0014\u001a\u00020\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/gamevault/discover/presentation/DiscoverViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/gamevault/discover/domain/repository/DiscoverRepository;", "(Lcom/gamevault/discover/domain/repository/DiscoverRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/gamevault/discover/presentation/DiscoverUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "addSection", "", "title", "", "games", "", "Lcom/gamevault/discover/domain/model/DiscoverGame;", "loadAll", "refresh", "discover_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DiscoverViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.gamevault.discover.domain.repository.DiscoverRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.gamevault.discover.presentation.DiscoverUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.gamevault.discover.presentation.DiscoverUiState> uiState = null;
    
    @javax.inject.Inject()
    public DiscoverViewModel(@org.jetbrains.annotations.NotNull()
    com.gamevault.discover.domain.repository.DiscoverRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.gamevault.discover.presentation.DiscoverUiState> getUiState() {
        return null;
    }
    
    public final void refresh() {
    }
    
    private final void loadAll() {
    }
    
    private final void addSection(java.lang.String title, java.util.List<com.gamevault.discover.domain.model.DiscoverGame> games) {
    }
}