package com.gamevault.gamelist.presentation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a4\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cH\u0007\u001a4\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cH\u0007\u001a.\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cH\u0007\u001a\u0012\u0010&\u001a\u00020\u00162\b\b\u0002\u0010\'\u001a\u00020(H\u0007\u001a\u0012\u0010)\u001a\u00020\u00162\b\b\u0002\u0010\'\u001a\u00020(H\u0007\u001a4\u0010*\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cH\u0007\u001ar\u0010+\u001a\u00020\u00162\b\b\u0002\u0010,\u001a\u00020\u001a2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00160.2\u0014\b\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00160.2\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c2\u001a\b\u0002\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001c\u0012\u0004\u0012\u00020\u00160.2\b\b\u0002\u00103\u001a\u000204H\u0007\u001aD\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020%2\b\b\u0002\u00109\u001a\u00020(2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00160.H\u0007\u001a2\u0010<\u001a\u00020\u00162\f\u0010=\u001a\b\u0012\u0004\u0012\u00020#0>2\u0006\u0010$\u001a\u00020#2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00160.H\u0007\u001a\u0012\u0010@\u001a\u00020\u00162\b\b\u0002\u0010\'\u001a\u00020(H\u0007\u001a,\u0010A\u001a\u00020\u00162\u0006\u0010$\u001a\u00020B2\u0006\u0010\'\u001a\u00020(2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u00160.H\u0007\u001a\"\u0010C\u001a\u00020\u00162\u0006\u0010D\u001a\u00020#2\u0006\u0010E\u001a\u00020/2\b\b\u0002\u0010\'\u001a\u00020(H\u0007\u001a.\u0010F\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020H2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cH\u0007\u001a\u0010\u0010J\u001a\u00020\u00162\u0006\u0010K\u001a\u00020#H\u0007\u001a\u0010\u0010L\u001a\u00020#2\u0006\u0010G\u001a\u00020HH\u0002\u001a\u0010\u0010M\u001a\u00020#2\u0006\u0010G\u001a\u00020HH\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0013\u0010\u0005\u001a\u00020\u0001\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0013\u0010\u0007\u001a\u00020\u0001\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\"\u0013\u0010\t\u001a\u00020\u0001\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\n\u0010\u0003\"\u0013\u0010\u000b\u001a\u00020\u0001\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\f\u0010\u0003\"\u0013\u0010\r\u001a\u00020\u0001\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u0003\"\u0013\u0010\u000f\u001a\u00020\u0001\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\u0003\"\u0013\u0010\u0011\u001a\u00020\u0001\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0012\u0010\u0003\"\u0013\u0010\u0013\u001a\u00020\u0001\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0014\u0010\u0003\u00a8\u0006N"}, d2 = {"FR", "Landroidx/compose/ui/graphics/Color;", "getFR", "()J", "J", "GLD", "getGLD", "SA", "getSA", "SB", "getSB", "SC", "getSC", "SD", "getSD", "SGL", "getSGL", "SS", "getSS", "ST", "getST", "BigCard", "", "game", "Lcom/gamevault/gamelist/domain/model/Game;", "prefs", "Lcom/gamevault/common/AppPrefs;", "onClick", "Lkotlin/Function0;", "onFav", "CompactCard", "DrawerBtn", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "label", "", "selected", "", "EmptyFavourites", "s", "Lcom/gamevault/common/AppStrings;", "EmptyFiltered", "GameCard", "GameListScreen", "externalPrefs", "onGameClick", "Lkotlin/Function1;", "", "onSettingsClick", "onDiscoverClick", "onClearCacheRequest", "viewModel", "Lcom/gamevault/gamelist/presentation/GameListViewModel;", "GameVaultDrawer", "activeSection", "Lcom/gamevault/gamelist/presentation/DrawerSection;", "isCompact", "strings", "onCompactToggle", "onSectionClick", "GenreRow", "genres", "", "onSelect", "LoadingState", "PlatformRow", "Lcom/gamevault/gamelist/domain/model/Platform;", "SectionLabel", "title", "count", "SortItem", "sort", "Lcom/gamevault/gamelist/presentation/SortOrder;", "current", "SortSectionLabel", "text", "sortBadge", "storeBannerText", "gamelist_debug"})
public final class GameListScreenKt {
    private static final long SD = 0L;
    private static final long SC = 0L;
    private static final long SB = 0L;
    private static final long SA = 0L;
    private static final long SGL = 0L;
    private static final long ST = 0L;
    private static final long SS = 0L;
    private static final long FR = 0L;
    private static final long GLD = 0L;
    
    public static final long getSD() {
        return 0L;
    }
    
    public static final long getSC() {
        return 0L;
    }
    
    public static final long getSB() {
        return 0L;
    }
    
    public static final long getSA() {
        return 0L;
    }
    
    public static final long getSGL() {
        return 0L;
    }
    
    public static final long getST() {
        return 0L;
    }
    
    public static final long getSS() {
        return 0L;
    }
    
    public static final long getFR() {
        return 0L;
    }
    
    public static final long getGLD() {
        return 0L;
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void GameListScreen(@org.jetbrains.annotations.NotNull()
    com.gamevault.common.AppPrefs externalPrefs, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onGameClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.gamevault.common.AppPrefs, kotlin.Unit> onSettingsClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDiscoverClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.jvm.functions.Function0<kotlin.Unit>, kotlin.Unit> onClearCacheRequest, @org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.presentation.GameListViewModel viewModel) {
    }
    
    private static final java.lang.String sortBadge(com.gamevault.gamelist.presentation.SortOrder sort) {
        return null;
    }
    
    private static final java.lang.String storeBannerText(com.gamevault.gamelist.presentation.SortOrder sort) {
        return null;
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SortSectionLabel(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SortItem(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.presentation.SortOrder sort, @org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.presentation.SortOrder current, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void GameCard(@org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.domain.model.Game game, @org.jetbrains.annotations.NotNull()
    com.gamevault.common.AppPrefs prefs, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onFav) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void BigCard(@org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.domain.model.Game game, @org.jetbrains.annotations.NotNull()
    com.gamevault.common.AppPrefs prefs, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onFav) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CompactCard(@org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.domain.model.Game game, @org.jetbrains.annotations.NotNull()
    com.gamevault.common.AppPrefs prefs, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onFav) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PlatformRow(@org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.domain.model.Platform selected, @org.jetbrains.annotations.NotNull()
    com.gamevault.common.AppStrings s, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.gamevault.gamelist.domain.model.Platform, kotlin.Unit> onSelect) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void GenreRow(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> genres, @org.jetbrains.annotations.NotNull()
    java.lang.String selected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSelect) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LoadingState(@org.jetbrains.annotations.NotNull()
    com.gamevault.common.AppStrings s) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void EmptyFavourites(@org.jetbrains.annotations.NotNull()
    com.gamevault.common.AppStrings s) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void EmptyFiltered(@org.jetbrains.annotations.NotNull()
    com.gamevault.common.AppStrings s) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SectionLabel(@org.jetbrains.annotations.NotNull()
    java.lang.String title, int count, @org.jetbrains.annotations.NotNull()
    com.gamevault.common.AppStrings s) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void GameVaultDrawer(@org.jetbrains.annotations.NotNull()
    com.gamevault.gamelist.presentation.DrawerSection activeSection, boolean isCompact, @org.jetbrains.annotations.NotNull()
    com.gamevault.common.AppStrings strings, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onCompactToggle, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.gamevault.gamelist.presentation.DrawerSection, kotlin.Unit> onSectionClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DrawerBtn(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.NotNull()
    java.lang.String label, boolean selected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
}