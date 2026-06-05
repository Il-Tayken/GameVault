package com.gamevault.gamelist.presentation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b0\b\u0087\b\u0018\u00002\u00020\u0001B\u00a9\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u001bJ\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0012H\u00c6\u0003J\t\u00107\u001a\u00020\u0006H\u00c6\u0003J\t\u00108\u001a\u00020\u0015H\u00c6\u0003J\t\u00109\u001a\u00020\u0017H\u00c6\u0003J\t\u0010:\u001a\u00020\u0019H\u00c6\u0003J\t\u0010;\u001a\u00020\u0006H\u00c6\u0003J\t\u0010<\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010>\u001a\u00020\nH\u00c6\u0003J\t\u0010?\u001a\u00020\bH\u00c6\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0003J\t\u0010A\u001a\u00020\u000eH\u00c6\u0003J\t\u0010B\u001a\u00020\bH\u00c6\u0003J\t\u0010C\u001a\u00020\u0006H\u00c6\u0003J\u00ad\u0001\u0010D\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010E\u001a\u00020\u00062\b\u0010F\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010G\u001a\u00020\u0019H\u00d6\u0001J\t\u0010H\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u001a\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u001fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\"R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u000f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0011\u0010\u000b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u0011\u0010\u0010\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104\u00a8\u0006I"}, d2 = {"Lcom/gamevault/gamelist/presentation/GameListUiState;", "", "allGames", "", "Lcom/gamevault/gamelist/domain/model/Game;", "isLoading", "", "error", "", "selectedPlatform", "Lcom/gamevault/gamelist/domain/model/Platform;", "selectedGenre", "availableGenres", "sortOrder", "Lcom/gamevault/gamelist/presentation/SortOrder;", "searchQuery", "showFavouritesOnly", "activeDrawerSection", "Lcom/gamevault/gamelist/presentation/DrawerSection;", "showAboutDialog", "prefs", "Lcom/gamevault/common/AppPrefs;", "strings", "Lcom/gamevault/common/AppStrings;", "cacheSize", "", "cacheClearedMessage", "(Ljava/util/List;ZLjava/lang/String;Lcom/gamevault/gamelist/domain/model/Platform;Ljava/lang/String;Ljava/util/List;Lcom/gamevault/gamelist/presentation/SortOrder;Ljava/lang/String;ZLcom/gamevault/gamelist/presentation/DrawerSection;ZLcom/gamevault/common/AppPrefs;Lcom/gamevault/common/AppStrings;IZ)V", "getActiveDrawerSection", "()Lcom/gamevault/gamelist/presentation/DrawerSection;", "getAllGames", "()Ljava/util/List;", "getAvailableGenres", "getCacheClearedMessage", "()Z", "getCacheSize", "()I", "displayGames", "getDisplayGames", "getError", "()Ljava/lang/String;", "getPrefs", "()Lcom/gamevault/common/AppPrefs;", "getSearchQuery", "getSelectedGenre", "getSelectedPlatform", "()Lcom/gamevault/gamelist/domain/model/Platform;", "getShowAboutDialog", "getShowFavouritesOnly", "getSortOrder", "()Lcom/gamevault/gamelist/presentation/SortOrder;", "getStrings", "()Lcom/gamevault/common/AppStrings;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "gamelist_debug"})
public final class GameListUiState {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.gamevault.gamelist.domain.model.Game> allGames = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String error = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gamevault.gamelist.domain.model.Platform selectedPlatform = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String selectedGenre = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> availableGenres = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gamevault.gamelist.presentation.SortOrder sortOrder = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String searchQuery = null;
    private final boolean showFavouritesOnly = false;
    @org.jetbrains.annotations.NotNull()
    private final com.gamevault.gamelist.presentation.DrawerSection activeDrawerSection = null;
    private final boolean showAboutDialog = false;
    @org.jetbrains.annotations.NotNull()
    private final com.gamevault.common.AppPrefs prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gamevault.common.AppStrings strings = null;
    private final int cacheSize = 0;
    private final boolean cacheClearedMessage = false;
    
    public GameListUiState(@org.jetbrains.annotations.NotNull()
    java.util.List<com.gamevault.gamelist.domain.model.Game> allGames, boolean isLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String error, @org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.domain.model.Platform selectedPlatform, @org.jetbrains.annotations.NotNull()
    java.lang.String selectedGenre, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> availableGenres, @org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.presentation.SortOrder sortOrder, @org.jetbrains.annotations.NotNull()
    java.lang.String searchQuery, boolean showFavouritesOnly, @org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.presentation.DrawerSection activeDrawerSection, boolean showAboutDialog, @org.jetbrains.annotations.NotNull()
    com.gamevault.common.AppPrefs prefs, @org.jetbrains.annotations.NotNull()
    com.gamevault.common.AppStrings strings, int cacheSize, boolean cacheClearedMessage) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.gamevault.gamelist.domain.model.Game> getAllGames() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gamevault.gamelist.domain.model.Platform getSelectedPlatform() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSelectedGenre() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getAvailableGenres() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gamevault.gamelist.presentation.SortOrder getSortOrder() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSearchQuery() {
        return null;
    }
    
    public final boolean getShowFavouritesOnly() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gamevault.gamelist.presentation.DrawerSection getActiveDrawerSection() {
        return null;
    }
    
    public final boolean getShowAboutDialog() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gamevault.common.AppPrefs getPrefs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gamevault.common.AppStrings getStrings() {
        return null;
    }
    
    public final int getCacheSize() {
        return 0;
    }
    
    public final boolean getCacheClearedMessage() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.gamevault.gamelist.domain.model.Game> getDisplayGames() {
        return null;
    }
    
    public GameListUiState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.gamevault.gamelist.domain.model.Game> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gamevault.gamelist.presentation.DrawerSection component10() {
        return null;
    }
    
    public final boolean component11() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gamevault.common.AppPrefs component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gamevault.common.AppStrings component13() {
        return null;
    }
    
    public final int component14() {
        return 0;
    }
    
    public final boolean component15() {
        return false;
    }
    
    public final boolean component2() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gamevault.gamelist.domain.model.Platform component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gamevault.gamelist.presentation.SortOrder component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gamevault.gamelist.presentation.GameListUiState copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.gamevault.gamelist.domain.model.Game> allGames, boolean isLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String error, @org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.domain.model.Platform selectedPlatform, @org.jetbrains.annotations.NotNull()
    java.lang.String selectedGenre, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> availableGenres, @org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.presentation.SortOrder sortOrder, @org.jetbrains.annotations.NotNull()
    java.lang.String searchQuery, boolean showFavouritesOnly, @org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.presentation.DrawerSection activeDrawerSection, boolean showAboutDialog, @org.jetbrains.annotations.NotNull()
    com.gamevault.common.AppPrefs prefs, @org.jetbrains.annotations.NotNull()
    com.gamevault.common.AppStrings strings, int cacheSize, boolean cacheClearedMessage) {
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