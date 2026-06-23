package com.gamevault.gamelist.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000e\u001a\u00020\fH&J\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0010\u001a\u00020\fH&J\u000e\u0010\u0011\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0012\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u001a\u00a8\u0006\u001b"}, d2 = {"Lcom/gamevault/gamelist/domain/repository/GameListRepository;", "", "clearCache", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCacheSize", "", "getGames", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/gamevault/gamelist/domain/model/Game;", "platform", "", "getGamesBySource", "source", "getGamesByStore", "storeId", "refreshEpicGames", "refreshGames", "useCache", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshSteamGames", "toggleFavorite", "gameId", "isFavorite", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gamelist_debug"})
public abstract interface GameListRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.gamevault.gamelist.domain.model.Game>> getGames(@org.jetbrains.annotations.Nullable()
    java.lang.String platform);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.gamevault.gamelist.domain.model.Game>> getGamesByStore(@org.jetbrains.annotations.NotNull()
    java.lang.String storeId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.gamevault.gamelist.domain.model.Game>> getGamesBySource(@org.jetbrains.annotations.NotNull()
    java.lang.String source);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object refreshGames(@org.jetbrains.annotations.Nullable()
    java.lang.String platform, boolean useCache, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object refreshSteamGames(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object refreshEpicGames(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object toggleFavorite(int gameId, boolean isFavorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clearCache(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCacheSize(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}