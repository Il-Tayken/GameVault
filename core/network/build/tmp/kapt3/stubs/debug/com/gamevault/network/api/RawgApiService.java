package com.gamevault.network.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\bf\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dJ\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJB\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\u000b\u001a\u00020\u00052\b\b\u0003\u0010\f\u001a\u00020\u00052\b\b\u0003\u0010\r\u001a\u00020\u00072\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u000fJJ\u0010\u0010\u001a\u00020\n2\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\f\u001a\u00020\u00052\b\b\u0003\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u0011\u001a\u00020\u00072\b\b\u0003\u0010\u000e\u001a\u00020\u00072\b\b\u0003\u0010\u0012\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u0013J@\u0010\u0014\u001a\u00020\n2\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\f\u001a\u00020\u00052\b\b\u0003\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u0011\u001a\u00020\u00072\b\b\u0003\u0010\u000e\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u0015J6\u0010\u0016\u001a\u00020\n2\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\f\u001a\u00020\u00052\b\b\u0003\u0010\r\u001a\u00020\u00072\b\b\u0003\u0010\u0017\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u0018J@\u0010\u0019\u001a\u00020\n2\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\f\u001a\u00020\u00052\b\b\u0003\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u00072\b\b\u0003\u0010\u0017\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u0015J@\u0010\u001a\u001a\u00020\n2\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\f\u001a\u00020\u00052\b\b\u0003\u0010\r\u001a\u00020\u00072\b\b\u0003\u0010\u000e\u001a\u00020\u00072\b\b\u0003\u0010\u0012\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u0015J@\u0010\u001b\u001a\u00020\n2\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\f\u001a\u00020\u00052\b\b\u0003\u0010\r\u001a\u00020\u00072\b\b\u0003\u0010\u000e\u001a\u00020\u00072\b\b\u0003\u0010\u0012\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u0015J@\u0010\u001c\u001a\u00020\n2\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\f\u001a\u00020\u00052\b\b\u0003\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u0011\u001a\u00020\u00072\b\b\u0003\u0010\u000e\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/gamevault/network/api/RawgApiService;", "", "getGameDetail", "Lcom/gamevault/network/model/GameDetailDto;", "id", "", "apiKey", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGames", "Lcom/gamevault/network/model/GamesResponse;", "page", "pageSize", "ordering", "platforms", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNewOnPC", "dates", "stores", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNewReleases", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPopular", "metacritic", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopByPlatform", "getTopEpic", "getTopSteam", "getUpcoming", "Companion", "network_debug"})
public abstract interface RawgApiService {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String API_KEY = "b30e7b08165a4f7c8f838bbc6740d585";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "https://api.rawg.io/api/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PC_ID = "4";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PS5_ID = "187";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PS4_ID = "18";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String XBOX_ONE_ID = "1";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String XBOX_SERIES_ID = "186";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NINTENDO_ID = "7";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STEAM_STORE_ID = "1";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EPIC_STORE_ID = "11";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PS_STORE_ID = "3";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String XBOX_STORE_ID = "2";
    @org.jetbrains.annotations.NotNull()
    public static final com.gamevault.network.api.RawgApiService.Companion Companion = null;
    
    @retrofit2.http.GET(value = "games")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getGames(@retrofit2.http.Query(value = "key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "page_size")
    int pageSize, @retrofit2.http.Query(value = "ordering")
    @org.jetbrains.annotations.NotNull()
    java.lang.String ordering, @retrofit2.http.Query(value = "platforms")
    @org.jetbrains.annotations.Nullable()
    java.lang.String platforms, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gamevault.network.model.GamesResponse> $completion);
    
    @retrofit2.http.GET(value = "games")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPopular(@retrofit2.http.Query(value = "key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "page_size")
    int pageSize, @retrofit2.http.Query(value = "ordering")
    @org.jetbrains.annotations.NotNull()
    java.lang.String ordering, @retrofit2.http.Query(value = "metacritic")
    @org.jetbrains.annotations.NotNull()
    java.lang.String metacritic, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gamevault.network.model.GamesResponse> $completion);
    
    @retrofit2.http.GET(value = "games")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNewReleases(@retrofit2.http.Query(value = "key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "page_size")
    int pageSize, @retrofit2.http.Query(value = "ordering")
    @org.jetbrains.annotations.NotNull()
    java.lang.String ordering, @retrofit2.http.Query(value = "dates")
    @org.jetbrains.annotations.NotNull()
    java.lang.String dates, @retrofit2.http.Query(value = "platforms")
    @org.jetbrains.annotations.NotNull()
    java.lang.String platforms, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gamevault.network.model.GamesResponse> $completion);
    
    @retrofit2.http.GET(value = "games")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUpcoming(@retrofit2.http.Query(value = "key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "page_size")
    int pageSize, @retrofit2.http.Query(value = "ordering")
    @org.jetbrains.annotations.NotNull()
    java.lang.String ordering, @retrofit2.http.Query(value = "dates")
    @org.jetbrains.annotations.NotNull()
    java.lang.String dates, @retrofit2.http.Query(value = "platforms")
    @org.jetbrains.annotations.NotNull()
    java.lang.String platforms, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gamevault.network.model.GamesResponse> $completion);
    
    @retrofit2.http.GET(value = "games")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTopByPlatform(@retrofit2.http.Query(value = "key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "page_size")
    int pageSize, @retrofit2.http.Query(value = "ordering")
    @org.jetbrains.annotations.NotNull()
    java.lang.String ordering, @retrofit2.http.Query(value = "platforms")
    @org.jetbrains.annotations.NotNull()
    java.lang.String platforms, @retrofit2.http.Query(value = "metacritic")
    @org.jetbrains.annotations.NotNull()
    java.lang.String metacritic, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gamevault.network.model.GamesResponse> $completion);
    
    @retrofit2.http.GET(value = "games")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNewOnPC(@retrofit2.http.Query(value = "key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "page_size")
    int pageSize, @retrofit2.http.Query(value = "ordering")
    @org.jetbrains.annotations.NotNull()
    java.lang.String ordering, @retrofit2.http.Query(value = "dates")
    @org.jetbrains.annotations.NotNull()
    java.lang.String dates, @retrofit2.http.Query(value = "platforms")
    @org.jetbrains.annotations.NotNull()
    java.lang.String platforms, @retrofit2.http.Query(value = "stores")
    @org.jetbrains.annotations.NotNull()
    java.lang.String stores, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gamevault.network.model.GamesResponse> $completion);
    
    @retrofit2.http.GET(value = "games")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTopSteam(@retrofit2.http.Query(value = "key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "page_size")
    int pageSize, @retrofit2.http.Query(value = "ordering")
    @org.jetbrains.annotations.NotNull()
    java.lang.String ordering, @retrofit2.http.Query(value = "platforms")
    @org.jetbrains.annotations.NotNull()
    java.lang.String platforms, @retrofit2.http.Query(value = "stores")
    @org.jetbrains.annotations.NotNull()
    java.lang.String stores, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gamevault.network.model.GamesResponse> $completion);
    
    @retrofit2.http.GET(value = "games")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTopEpic(@retrofit2.http.Query(value = "key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "page_size")
    int pageSize, @retrofit2.http.Query(value = "ordering")
    @org.jetbrains.annotations.NotNull()
    java.lang.String ordering, @retrofit2.http.Query(value = "platforms")
    @org.jetbrains.annotations.NotNull()
    java.lang.String platforms, @retrofit2.http.Query(value = "stores")
    @org.jetbrains.annotations.NotNull()
    java.lang.String stores, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gamevault.network.model.GamesResponse> $completion);
    
    @retrofit2.http.GET(value = "games/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getGameDetail(@retrofit2.http.Path(value = "id")
    int id, @retrofit2.http.Query(value = "key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gamevault.network.model.GameDetailDto> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/gamevault/network/api/RawgApiService$Companion;", "", "()V", "API_KEY", "", "BASE_URL", "EPIC_STORE_ID", "NINTENDO_ID", "PC_ID", "PS4_ID", "PS5_ID", "PS_STORE_ID", "STEAM_STORE_ID", "XBOX_ONE_ID", "XBOX_SERIES_ID", "XBOX_STORE_ID", "network_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String API_KEY = "b30e7b08165a4f7c8f838bbc6740d585";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BASE_URL = "https://api.rawg.io/api/";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String PC_ID = "4";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String PS5_ID = "187";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String PS4_ID = "18";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String XBOX_ONE_ID = "1";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String XBOX_SERIES_ID = "186";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NINTENDO_ID = "7";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String STEAM_STORE_ID = "1";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String EPIC_STORE_ID = "11";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String PS_STORE_ID = "3";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String XBOX_STORE_ID = "2";
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}