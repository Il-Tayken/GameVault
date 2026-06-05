package com.gamevault.gamelist.presentation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0017J\u0006\u0010\u001f\u001a\u00020\u0017J\u000e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u000fJ\u000e\u0010%\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010&\u001a\u00020\u0017J\u000e\u0010\'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020\u0017J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202J\u0010\u00103\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u00104\u001a\u00020\u0017H\u0002J\u0010\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u000fH\u0002R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u00067"}, d2 = {"Lcom/gamevault/gamelist/presentation/GameListViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "getGamesUseCase", "Lcom/gamevault/gamelist/domain/usecase/GetGamesUseCase;", "refreshGamesUseCase", "Lcom/gamevault/gamelist/domain/usecase/RefreshGamesUseCase;", "toggleFavoriteUseCase", "Lcom/gamevault/gamelist/domain/usecase/ToggleFavoriteUseCase;", "repository", "Lcom/gamevault/gamelist/domain/repository/GameListRepository;", "(Landroid/content/Context;Lcom/gamevault/gamelist/domain/usecase/GetGamesUseCase;Lcom/gamevault/gamelist/domain/usecase/RefreshGamesUseCase;Lcom/gamevault/gamelist/domain/usecase/ToggleFavoriteUseCase;Lcom/gamevault/gamelist/domain/repository/GameListRepository;)V", "_searchQuery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_uiState", "Lcom/gamevault/gamelist/presentation/GameListUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadCacheSize", "", "observeGames", "platform", "Lcom/gamevault/gamelist/domain/model/Platform;", "onApplyPrefs", "prefs", "Lcom/gamevault/common/AppPrefs;", "onClearCache", "onDismissAboutDialog", "onDrawerSectionSelected", "section", "Lcom/gamevault/gamelist/presentation/DrawerSection;", "onGenreSelected", "genre", "onPlatformSelected", "onRefresh", "onSearchQuery", "q", "onSortSelected", "sort", "Lcom/gamevault/gamelist/presentation/SortOrder;", "onToggleCompact", "onToggleFavorite", "Lkotlinx/coroutines/Job;", "id", "", "fav", "", "refresh", "requestNotificationPermissionIfNeeded", "sendFavoriteNotification", "gameName", "gamelist_debug"})
@kotlin.OptIn(markerClass = {kotlinx.coroutines.FlowPreview.class})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class GameListViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gamevault.gamelist.domain.usecase.GetGamesUseCase getGamesUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gamevault.gamelist.domain.usecase.RefreshGamesUseCase refreshGamesUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gamevault.gamelist.domain.usecase.ToggleFavoriteUseCase toggleFavoriteUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gamevault.gamelist.domain.repository.GameListRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.gamevault.gamelist.presentation.GameListUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.gamevault.gamelist.presentation.GameListUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    
    @javax.inject.Inject()
    public GameListViewModel(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.domain.usecase.GetGamesUseCase getGamesUseCase, @org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.domain.usecase.RefreshGamesUseCase refreshGamesUseCase, @org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.domain.usecase.ToggleFavoriteUseCase toggleFavoriteUseCase, @org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.domain.repository.GameListRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.gamevault.gamelist.presentation.GameListUiState> getUiState() {
        return null;
    }
    
    public final void onPlatformSelected(@org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.domain.model.Platform platform) {
    }
    
    public final void onGenreSelected(@org.jetbrains.annotations.NotNull()
    java.lang.String genre) {
    }
    
    public final void onSortSelected(@org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.presentation.SortOrder sort) {
    }
    
    public final void onSearchQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String q) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onToggleFavorite(int id, boolean fav) {
        return null;
    }
    
    public final void onToggleCompact() {
    }
    
    public final void onDrawerSectionSelected(@org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.presentation.DrawerSection section) {
    }
    
    public final void onDismissAboutDialog() {
    }
    
    public final void onRefresh() {
    }
    
    public final void onClearCache() {
    }
    
    public final void onApplyPrefs(@org.jetbrains.annotations.NotNull()
    com.gamevault.common.AppPrefs prefs) {
    }
    
    private final void observeGames(com.gamevault.gamelist.domain.model.Platform platform) {
    }
    
    private final void refresh(com.gamevault.gamelist.domain.model.Platform platform) {
    }
    
    private final void loadCacheSize() {
    }
    
    private final void sendFavoriteNotification(java.lang.String gameName) {
    }
    
    private final void requestNotificationPermissionIfNeeded() {
    }
}