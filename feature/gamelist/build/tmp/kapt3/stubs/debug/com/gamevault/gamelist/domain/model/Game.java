package com.gamevault.gamelist.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b-\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0015J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u00c6\u0003J\t\u0010,\u001a\u00020\u0011H\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u00c6\u0003J\t\u0010/\u001a\u00020\u0005H\u00c6\u0003J\t\u00100\u001a\u00020\u0005H\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u00102\u001a\u00020\bH\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u00c6\u0003J\u00b4\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020\u00112\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010<\u001a\u00020\u0003H\u00d6\u0001J\t\u0010=\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001dR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0017R\u0011\u0010\u0014\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001a\u00a8\u0006>"}, d2 = {"Lcom/gamevault/gamelist/domain/model/Game;", "", "id", "", "name", "", "backgroundImage", "rating", "", "ratingTop", "released", "metacritic", "playtime", "platforms", "", "genres", "isFavorite", "", "esrbRating", "storeIds", "source", "(ILjava/lang/String;Ljava/lang/String;DILjava/lang/String;Ljava/lang/Integer;ILjava/util/List;Ljava/util/List;ZLjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getBackgroundImage", "()Ljava/lang/String;", "getEsrbRating", "getGenres", "()Ljava/util/List;", "getId", "()I", "()Z", "getMetacritic", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "getPlatforms", "getPlaytime", "getRating", "()D", "getRatingTop", "getReleased", "getSource", "getStoreIds", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;DILjava/lang/String;Ljava/lang/Integer;ILjava/util/List;Ljava/util/List;ZLjava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/gamevault/gamelist/domain/model/Game;", "equals", "other", "hashCode", "toString", "gamelist_debug"})
public final class Game {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String backgroundImage = null;
    private final double rating = 0.0;
    private final int ratingTop = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String released = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer metacritic = null;
    private final int playtime = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> platforms = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> genres = null;
    private final boolean isFavorite = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String esrbRating = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> storeIds = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String source = null;
    
    public Game(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String backgroundImage, double rating, int ratingTop, @org.jetbrains.annotations.Nullable()
    java.lang.String released, @org.jetbrains.annotations.Nullable()
    java.lang.Integer metacritic, int playtime, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> platforms, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> genres, boolean isFavorite, @org.jetbrains.annotations.Nullable()
    java.lang.String esrbRating, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> storeIds, @org.jetbrains.annotations.NotNull()
    java.lang.String source) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBackgroundImage() {
        return null;
    }
    
    public final double getRating() {
        return 0.0;
    }
    
    public final int getRatingTop() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReleased() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getMetacritic() {
        return null;
    }
    
    public final int getPlaytime() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getPlatforms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getGenres() {
        return null;
    }
    
    public final boolean isFavorite() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEsrbRating() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getStoreIds() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSource() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component10() {
        return null;
    }
    
    public final boolean component11() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    public final double component4() {
        return 0.0;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component7() {
        return null;
    }
    
    public final int component8() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gamevault.gamelist.domain.model.Game copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String backgroundImage, double rating, int ratingTop, @org.jetbrains.annotations.Nullable()
    java.lang.String released, @org.jetbrains.annotations.Nullable()
    java.lang.Integer metacritic, int playtime, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> platforms, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> genres, boolean isFavorite, @org.jetbrains.annotations.Nullable()
    java.lang.String esrbRating, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> storeIds, @org.jetbrains.annotations.NotNull()
    java.lang.String source) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}