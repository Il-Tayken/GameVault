package com.gamevault.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0017\u0018\u00002\u00020\u0001:\u0004+,-.B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eJ\u00d2\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\b\b\u0000\u0010\u000f*\u00020\u00102\u00b9\u0002\u0010\u0011\u001a\u00b4\u0002\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\b\u0012\u0004\u0012\u0002H\u000f0\u0012J\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u0016\u001a\u00020\u0013J\u00da\u0002\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\b\b\u0000\u0010\u000f*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00132\u00b9\u0002\u0010\u0011\u001a\u00b4\u0002\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\b\u0012\u0004\u0012\u0002H\u000f0\u0012J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010%\u001a\u00020\tJ\u00da\u0002\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\b\b\u0000\u0010\u000f*\u00020\u00102\u0006\u0010%\u001a\u00020\t2\u00b9\u0002\u0010\u0011\u001a\u00b4\u0002\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\b\u0012\u0004\u0012\u0002H\u000f0\u0012J\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\b\u001a\u00020\tJ\u00da\u0002\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\b\b\u0000\u0010\u000f*\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u00b9\u0002\u0010\u0011\u001a\u00b4\u0002\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\b\u0012\u0004\u0012\u0002H\u000f0\u0012J\u0014\u0010\'\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010(\u001a\u00020\tJ\u00da\u0002\u0010\'\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\b\b\u0000\u0010\u000f*\u00020\u00102\u0006\u0010(\u001a\u00020\t2\u00b9\u0002\u0010\u0011\u001a\u00b4\u0002\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\b\u0012\u0004\u0012\u0002H\u000f0\u0012J\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u000eJ\u00d2\u0002\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\b\b\u0000\u0010\u000f*\u00020\u00102\u00b9\u0002\u0010\u0011\u001a\u00b4\u0002\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\b\u0012\u0004\u0012\u0002H\u000f0\u0012J\u0016\u0010*\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013\u00a8\u0006/"}, d2 = {"Lcom/gamevault/database/GameEntityQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "deleteAll", "", "deleteNonFavoritesBySource", "source", "", "insert", "GameEntity", "Lcom/gamevault/database/GameEntity;", "selectAll", "Lapp/cash/sqldelight/Query;", "T", "", "mapper", "Lkotlin/Function14;", "", "Lkotlin/ParameterName;", "name", "id", "backgroundImage", "", "rating", "ratingTop", "released", "metacritic", "playtime", "platforms", "genres", "shortScreenshots", "isFavorite", "storeIds", "selectById", "selectByPlatform", "platform", "selectBySource", "selectByStore", "storeId", "selectFavorites", "updateFavorite", "SelectByIdQuery", "SelectByPlatformQuery", "SelectBySourceQuery", "SelectByStoreQuery", "database_debug"})
public final class GameEntityQueries extends app.cash.sqldelight.TransacterImpl {
    
    public GameEntityQueries(@org.jetbrains.annotations.NotNull()
    app.cash.sqldelight.db.SqlDriver driver) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>app.cash.sqldelight.Query<T> selectAll(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function14<? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.Long, ? super java.lang.String, ? super java.lang.Long, ? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<com.gamevault.database.GameEntity> selectAll() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>app.cash.sqldelight.Query<T> selectByPlatform(@org.jetbrains.annotations.NotNull()
    java.lang.String platform, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function14<? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.Long, ? super java.lang.String, ? super java.lang.Long, ? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<com.gamevault.database.GameEntity> selectByPlatform(@org.jetbrains.annotations.NotNull()
    java.lang.String platform) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>app.cash.sqldelight.Query<T> selectByStore(@org.jetbrains.annotations.NotNull()
    java.lang.String storeId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function14<? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.Long, ? super java.lang.String, ? super java.lang.Long, ? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<com.gamevault.database.GameEntity> selectByStore(@org.jetbrains.annotations.NotNull()
    java.lang.String storeId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>app.cash.sqldelight.Query<T> selectBySource(@org.jetbrains.annotations.NotNull()
    java.lang.String source, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function14<? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.Long, ? super java.lang.String, ? super java.lang.Long, ? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<com.gamevault.database.GameEntity> selectBySource(@org.jetbrains.annotations.NotNull()
    java.lang.String source) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>app.cash.sqldelight.Query<T> selectById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function14<? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.Long, ? super java.lang.String, ? super java.lang.Long, ? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<com.gamevault.database.GameEntity> selectById(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>app.cash.sqldelight.Query<T> selectFavorites(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function14<? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.Long, ? super java.lang.String, ? super java.lang.Long, ? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<com.gamevault.database.GameEntity> selectFavorites() {
        return null;
    }
    
    public final void insert(@org.jetbrains.annotations.NotNull()
    com.gamevault.database.GameEntity GameEntity) {
    }
    
    public final void updateFavorite(long isFavorite, long id) {
    }
    
    public final void deleteNonFavoritesBySource(@org.jetbrains.annotations.NotNull()
    java.lang.String source) {
    }
    
    public final void deleteAll() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J.\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\b\u0001\u0010\u00122\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00110\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/gamevault/database/GameEntityQueries$SelectByIdQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "id", "", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "(Lcom/gamevault/database/GameEntityQueries;JLkotlin/jvm/functions/Function1;)V", "getId", "()J", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "removeListener", "toString", "", "database_debug"})
    final class SelectByIdQuery<T extends java.lang.Object> extends app.cash.sqldelight.Query<T> {
        private final long id = 0L;
        
        public SelectByIdQuery(long id, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends T> mapper) {
            super(null);
        }
        
        public final long getId() {
            return 0L;
        }
        
        @java.lang.Override()
        public void addListener(@org.jetbrains.annotations.NotNull()
        app.cash.sqldelight.Query.Listener listener) {
        }
        
        @java.lang.Override()
        public void removeListener(@org.jetbrains.annotations.NotNull()
        app.cash.sqldelight.Query.Listener listener) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public <R extends java.lang.Object>app.cash.sqldelight.db.QueryResult<R> execute(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends app.cash.sqldelight.db.QueryResult<R>> mapper) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J.\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\b\u0001\u0010\u00122\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00110\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/gamevault/database/GameEntityQueries$SelectByPlatformQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "platform", "", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "(Lcom/gamevault/database/GameEntityQueries;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getPlatform", "()Ljava/lang/String;", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "removeListener", "toString", "database_debug"})
    final class SelectByPlatformQuery<T extends java.lang.Object> extends app.cash.sqldelight.Query<T> {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String platform = null;
        
        public SelectByPlatformQuery(@org.jetbrains.annotations.NotNull()
        java.lang.String platform, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends T> mapper) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPlatform() {
            return null;
        }
        
        @java.lang.Override()
        public void addListener(@org.jetbrains.annotations.NotNull()
        app.cash.sqldelight.Query.Listener listener) {
        }
        
        @java.lang.Override()
        public void removeListener(@org.jetbrains.annotations.NotNull()
        app.cash.sqldelight.Query.Listener listener) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public <R extends java.lang.Object>app.cash.sqldelight.db.QueryResult<R> execute(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends app.cash.sqldelight.db.QueryResult<R>> mapper) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J.\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\b\u0001\u0010\u00122\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00110\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/gamevault/database/GameEntityQueries$SelectBySourceQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "source", "", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "(Lcom/gamevault/database/GameEntityQueries;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getSource", "()Ljava/lang/String;", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "removeListener", "toString", "database_debug"})
    final class SelectBySourceQuery<T extends java.lang.Object> extends app.cash.sqldelight.Query<T> {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String source = null;
        
        public SelectBySourceQuery(@org.jetbrains.annotations.NotNull()
        java.lang.String source, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends T> mapper) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSource() {
            return null;
        }
        
        @java.lang.Override()
        public void addListener(@org.jetbrains.annotations.NotNull()
        app.cash.sqldelight.Query.Listener listener) {
        }
        
        @java.lang.Override()
        public void removeListener(@org.jetbrains.annotations.NotNull()
        app.cash.sqldelight.Query.Listener listener) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public <R extends java.lang.Object>app.cash.sqldelight.db.QueryResult<R> execute(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends app.cash.sqldelight.db.QueryResult<R>> mapper) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J.\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\b\u0001\u0010\u00122\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00110\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/gamevault/database/GameEntityQueries$SelectByStoreQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "storeId", "", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "(Lcom/gamevault/database/GameEntityQueries;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getStoreId", "()Ljava/lang/String;", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "removeListener", "toString", "database_debug"})
    final class SelectByStoreQuery<T extends java.lang.Object> extends app.cash.sqldelight.Query<T> {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String storeId = null;
        
        public SelectByStoreQuery(@org.jetbrains.annotations.NotNull()
        java.lang.String storeId, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends T> mapper) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getStoreId() {
            return null;
        }
        
        @java.lang.Override()
        public void addListener(@org.jetbrains.annotations.NotNull()
        app.cash.sqldelight.Query.Listener listener) {
        }
        
        @java.lang.Override()
        public void removeListener(@org.jetbrains.annotations.NotNull()
        app.cash.sqldelight.Query.Listener listener) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public <R extends java.lang.Object>app.cash.sqldelight.db.QueryResult<R> execute(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends app.cash.sqldelight.db.QueryResult<R>> mapper) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}