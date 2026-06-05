package com.gamevault.gamedetail.domain.usecase;

import com.gamevault.gamedetail.domain.repository.GameDetailRepository;
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
public final class ToggleDetailFavoriteUseCase_Factory implements Factory<ToggleDetailFavoriteUseCase> {
  private final Provider<GameDetailRepository> repositoryProvider;

  public ToggleDetailFavoriteUseCase_Factory(Provider<GameDetailRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public ToggleDetailFavoriteUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static ToggleDetailFavoriteUseCase_Factory create(
      Provider<GameDetailRepository> repositoryProvider) {
    return new ToggleDetailFavoriteUseCase_Factory(repositoryProvider);
  }

  public static ToggleDetailFavoriteUseCase newInstance(GameDetailRepository repository) {
    return new ToggleDetailFavoriteUseCase(repository);
  }
}
