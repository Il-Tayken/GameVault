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
public final class GetGamesUseCase_Factory implements Factory<GetGamesUseCase> {
  private final Provider<GameListRepository> repositoryProvider;

  public GetGamesUseCase_Factory(Provider<GameListRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetGamesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetGamesUseCase_Factory create(Provider<GameListRepository> repositoryProvider) {
    return new GetGamesUseCase_Factory(repositoryProvider);
  }

  public static GetGamesUseCase newInstance(GameListRepository repository) {
    return new GetGamesUseCase(repository);
  }
}
