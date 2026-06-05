package com.gamevault.discover.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0005J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0005J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0005J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0005J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0005J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0005J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\r"}, d2 = {"Lcom/gamevault/discover/domain/repository/DiscoverRepository;", "", "getNewOnPC", "", "Lcom/gamevault/discover/domain/model/DiscoverGame;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNewReleases", "getPopular", "getTopOnEpic", "getTopOnPS", "getTopOnSteam", "getTopOnXbox", "getUpcoming", "discover_debug"})
public abstract interface DiscoverRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPopular(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gamevault.discover.domain.model.DiscoverGame>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNewReleases(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gamevault.discover.domain.model.DiscoverGame>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUpcoming(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gamevault.discover.domain.model.DiscoverGame>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNewOnPC(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gamevault.discover.domain.model.DiscoverGame>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTopOnSteam(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gamevault.discover.domain.model.DiscoverGame>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTopOnEpic(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gamevault.discover.domain.model.DiscoverGame>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTopOnPS(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gamevault.discover.domain.model.DiscoverGame>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTopOnXbox(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gamevault.discover.domain.model.DiscoverGame>> $completion);
}