package com.gamevault.gamelist.presentation;

import android.content.Context;
import com.gamevault.gamelist.domain.repository.GameListRepository;
import com.gamevault.gamelist.domain.usecase.GetGamesUseCase;
import com.gamevault.gamelist.domain.usecase.RefreshGamesUseCase;
import com.gamevault.gamelist.domain.usecase.ToggleFavoriteUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class GameListViewModel_Factory implements Factory<GameListViewModel> {
  private final Provider<Context> contextProvider;

  private final Provider<GetGamesUseCase> getGamesUseCaseProvider;

  private final Provider<RefreshGamesUseCase> refreshGamesUseCaseProvider;

  private final Provider<ToggleFavoriteUseCase> toggleFavoriteUseCaseProvider;

  private final Provider<GameListRepository> repositoryProvider;

  public GameListViewModel_Factory(Provider<Context> contextProvider,
      Provider<GetGamesUseCase> getGamesUseCaseProvider,
      Provider<RefreshGamesUseCase> refreshGamesUseCaseProvider,
      Provider<ToggleFavoriteUseCase> toggleFavoriteUseCaseProvider,
      Provider<GameListRepository> repositoryProvider) {
    this.contextProvider = contextProvider;
    this.getGamesUseCaseProvider = getGamesUseCaseProvider;
    this.refreshGamesUseCaseProvider = refreshGamesUseCaseProvider;
    this.toggleFavoriteUseCaseProvider = toggleFavoriteUseCaseProvider;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GameListViewModel get() {
    return newInstance(contextProvider.get(), getGamesUseCaseProvider.get(), refreshGamesUseCaseProvider.get(), toggleFavoriteUseCaseProvider.get(), repositoryProvider.get());
  }

  public static GameListViewModel_Factory create(Provider<Context> contextProvider,
      Provider<GetGamesUseCase> getGamesUseCaseProvider,
      Provider<RefreshGamesUseCase> refreshGamesUseCaseProvider,
      Provider<ToggleFavoriteUseCase> toggleFavoriteUseCaseProvider,
      Provider<GameListRepository> repositoryProvider) {
    return new GameListViewModel_Factory(contextProvider, getGamesUseCaseProvider, refreshGamesUseCaseProvider, toggleFavoriteUseCaseProvider, repositoryProvider);
  }

  public static GameListViewModel newInstance(Context context, GetGamesUseCase getGamesUseCase,
      RefreshGamesUseCase refreshGamesUseCase, ToggleFavoriteUseCase toggleFavoriteUseCase,
      GameListRepository repository) {
    return new GameListViewModel(context, getGamesUseCase, refreshGamesUseCase, toggleFavoriteUseCase, repository);
  }
}
