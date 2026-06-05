package com.gamevault.gamelist.domain.usecase;

import com.gamevault.gamelist.domain.repository.GameListRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
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
public final class RefreshGamesUseCase_Factory implements Factory<RefreshGamesUseCase> {
  private final Provider<GameListRepository> repositoryProvider;

  public RefreshGamesUseCase_Factory(Provider<GameListRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public RefreshGamesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static RefreshGamesUseCase_Factory create(
      Provider<GameListRepository> repositoryProvider) {
    return new RefreshGamesUseCase_Factory(repositoryProvider);
  }

  public static RefreshGamesUseCase newInstance(GameListRepository repository) {
    return new RefreshGamesUseCase(repository);
  }
}
