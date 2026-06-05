package com.gamevault.gamedetail.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a6@\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/gamevault/gamedetail/domain/repository/GameDetailRepository;", "", "fetchGameDetail", "", "gameId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGameDetail", "Lkotlinx/coroutines/flow/Flow;", "Lcom/gamevault/gamedetail/domain/model/GameDetail;", "toggleFavorite", "isFavorite", "", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gamedetail_debug"})
public abstract interface GameDetailRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.gamevault.gamedetail.domain.model.GameDetail> getGameDetail(int gameId);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object fetchGameDetail(int gameId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object toggleFavorite(int gameId, boolean isFavorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}