package com.gamevault.gamedetail.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001e\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/gamevault/gamedetail/data/repository/GameDetailRepositoryImpl;", "Lcom/gamevault/gamedetail/domain/repository/GameDetailRepository;", "apiService", "Lcom/gamevault/network/api/RawgApiService;", "database", "Lcom/gamevault/database/GameVaultDatabase;", "(Lcom/gamevault/network/api/RawgApiService;Lcom/gamevault/database/GameVaultDatabase;)V", "fetchGameDetail", "", "gameId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGameDetail", "Lkotlinx/coroutines/flow/Flow;", "Lcom/gamevault/gamedetail/domain/model/GameDetail;", "toggleFavorite", "isFavorite", "", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gamedetail_debug"})
public final class GameDetailRepositoryImpl implements com.gamevault.gamedetail.domain.repository.GameDetailRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.gamevault.network.api.RawgApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gamevault.database.GameVaultDatabase database = null;
    
    @javax.inject.Inject()
    public GameDetailRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.gamevault.network.api.RawgApiService apiService, @org.jetbrains.annotations.NotNull()
    com.gamevault.database.GameVaultDatabase database) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.gamevault.gamedetail.domain.model.GameDetail> getGameDetail(int gameId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object fetchGameDetail(int gameId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object toggleFavorite(int gameId, boolean isFavorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}